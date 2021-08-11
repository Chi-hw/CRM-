package com.chw.chw.workbench.web.controller;

import com.chw.chw.commons.contants.Contants;
import com.chw.chw.commons.domain.ReturnObject;
import com.chw.chw.commons.utils.DateUtils;
import com.chw.chw.commons.utils.UUIDUtils;
import com.chw.chw.settings.domain.User;
import com.chw.chw.settings.service.UserService;
import com.chw.chw.workbench.domain.Activity;
import com.chw.chw.workbench.domain.ActivityRemark;
import com.chw.chw.workbench.service.ActivityService;
import com.chw.chw.workbench.service.ActivityRemarkService;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.net.URLEncoder;

@Controller
public class ActivityController {
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityRemarkService activityRemarkService;
    @RequestMapping("/workbench/activity/index.do")
    public String index(Model model){
        List<User> ulist=userService.getUser();
        model.addAttribute("ulist",ulist);
        return "workbench/activity/index";
    }

    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    public @ResponseBody Object saveCreateActivity(Activity activity, HttpSession session){
        User user= (User) session.getAttribute(Contants.SESSION_USER);
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
        activity.setCreateBy(user.getId());
        ReturnObject returnObject=new ReturnObject();
        try{
         //保存市场活动
            int ret=activityService.saveCreateActivity(activity);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("创建市场活动成功");
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("创建市场活动失败，请重试。。。");
            }

        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("创建市场活动失败，请重试。。。");
        }

        return  returnObject;
    }

    @RequestMapping("/workbench/activity/queryActivityForPageByCondition.do")
    public @ResponseBody Object queryActivityForPageByCondition(int pageNo,int pageSize,String name,String owner,String startDate,String endDate){
        Map<String,Object> map= new HashMap<>();
        map.put("beginNo",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        //查询出的数据列表
        List<Activity> activityList=activityService.queryActivityForPageByCondition(map);

        //查询出的总条数
        long totalRows=activityService.queryCountOfActivityByCondition(map);
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("activityList",activityList );
        retMap.put("totalRows", totalRows);

        return retMap;
    }
    @RequestMapping("/workbench/activity/editActivity.do")
    public @ResponseBody Object editActivity(String id){
        Activity activity=activityService.queryActivityById(id);
        return activity;
    }
    @RequestMapping("/workbench/activity/saveEditActivity.do")
    public @ResponseBody Object saveEditActivity(Activity activity,HttpSession session){
        User user= (User) session.getAttribute(Contants.SESSION_USER);
        System.out.println("+++++"+user.getId());
        System.out.println("+++++"+activity.getId());
        activity.setEditBy(user.getId());
        activity.setEditTime(DateUtils.formatDateTime(new Date()));
        ReturnObject returnObject=new ReturnObject();
        try {
            int ret= activityService.saveEditActivity(activity);
            if(ret>0)
            {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("修改成功");
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("修改失败");
        }
        return returnObject;
    }
    @RequestMapping("/workbench/activity/deleteActivityByIds.do")
    public @ResponseBody Object deleteActivityByIds(String[] id){
        ReturnObject returnObject=new ReturnObject();
        try {
            int ret=activityService.deleteActivityByIds(id);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("删除成功");
            }else {

                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");
        }

        return returnObject;
    }
    @RequestMapping("/workbench/activity/exportAllActivity.do")
    public void exportAllActivity(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //用service层方法，查询所有的市场活动
        List<Activity> activityList=activityService.queryAllActivityForDetail();
        //根据查询结果，生成响应信息
        //1.创建HSSFWork对象，对应一个execl文件
        HSSFWorkbook wb=new HSSFWorkbook();
        //2.使用wb创建HSSFSheet对象，对应一个页
        HSSFSheet sheet=wb.createSheet("市场活动列表");
        //3.使用sheet创建HSSFRow对象，对应一行
        HSSFRow row=sheet.createRow(0);//行编号，0开始，0第一行
        //4.使用row创建三个HSSFCell对象，对应三列
        HSSFCell cell=row.createCell(0);//列编号，0开始，0第一列

        cell.setCellValue("ID");
        cell=row.createCell(1);
        cell.setCellValue("所有者");
        cell=row.createCell(2);
        cell.setCellValue("名称");
        cell=row.createCell(3);
        cell.setCellValue("开始日期");
        cell=row.createCell(4);
        cell.setCellValue("结束日期");
        cell=row.createCell(5);
        cell.setCellValue("成本");
        cell=row.createCell(6);
        cell.setCellValue("描述");
        cell=row.createCell(7);
        cell.setCellValue("创建者");
        cell=row.createCell(8);
        cell.setCellValue("创建时间");
        cell=row.createCell(9);
        cell.setCellValue("修改者");
        cell=row.createCell(10);
        cell.setCellValue("修改时间");
        //cell=row.createCell(11);

        //创建HSSFCellStyle对象，对应样式
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        //5.遍历activityList,显示数据行
        if(activityList!=null){
            Activity activity=null;
            for(int i=0;i<activityList.size();i++){
                activity=activityList.get(i);
                row=sheet.createRow(i+1);//创建一行

                cell=row.createCell(0);
                cell.setCellValue(activity.getId());
                cell=row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell=row.createCell(2);
                cell.setCellValue(activity.getName());
                cell=row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell=row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell=row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell=row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell=row.createCell(7);
                cell.setCellValue(activity.getCreateBy());
                cell=row.createCell(8);
                cell.setCellValue(activity.getCreateTime());
                cell=row.createCell(9);
                cell.setCellValue(activity.getEditBy());
                cell=row.createCell(10);
                cell.setCellValue(activity.getEditTime());
            }
        }
        //使用wb生成excel文件
        //OutputStream os=new FileOutputStream("F:\\teaching\\section05\\testDir\\activity.xls");//文件可以自动创建，目录必须手动创建。
        //wb.write(os);//效率低
        //os.close();
        //wb.close();
        //返回响应信息
        //1.设置响应类型
        response.setContentType("application/octet-stream;charset=UTF-8");
        //根据HTTP协议的规定，浏览器每次向服务器发送请求，都会把浏览器信息以请求头的形式发送到服务器
        String browser=request.getHeader("User-Agent");

        //不同的浏览器接收响应头采用的编码格式不一样：
        //IE采用 urlencoded
        ////火狐采用 ISO8859-1
        String fileName=URLEncoder.encode("市场活动列表","UTF-8");
        if(browser.contains("firefox")){
            //火狐采用 ISO8859-1
            fileName=new String("市场活动列表".getBytes("UTF-8"),"ISO8859-1");
        }
        //默认情况下，浏览器接收到响应信息之后，直接在显示窗口中打开；
        //可以设置响应头信息，使浏览器接收到响应信息之后，在下载窗口打开
        response.addHeader("Content-Disposition","attachment;filename="+fileName+".xls");
        //2.获取输出流
        OutputStream os2=response.getOutputStream();

        //3.读取student.xls文件，通过os输出到浏览器
        //InputStream is=new FileInputStream("F:\\teaching\\section05\\testDir\\activity.xls");

        //byte[] buff=new byte[256];
        //int len=0;
        //while((len=is.read(buff))!=-1){
        // os2.write(buff,0,len);
        // }
        //4.关闭资源
        //is.close();

        wb.write(os2);
        os2.flush();
        wb.close();
    }
    @RequestMapping("/workbench/activity/exportActivitySelective.do")
    public void exportActivitySelective(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
        //调用service层方法，查询市场活动
        List<Activity> activityList=activityService.queryActivityForDetailByIds(id);
        //根据查询结果，生成excel文件
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("市场活动列表");
        HSSFRow row=sheet.createRow(0);
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("ID");
        cell=row.createCell(1);
        cell.setCellValue("所有者");
        cell=row.createCell(2);
        cell.setCellValue("名称");
        cell=row.createCell(3);
        cell.setCellValue("开始日期");
        cell=row.createCell(4);
        cell.setCellValue("结束日期");
        cell=row.createCell(5);
        cell.setCellValue("成本");
        cell=row.createCell(6);
        cell.setCellValue("描述");
        cell=row.createCell(7);
        cell.setCellValue("创建者");
        cell=row.createCell(8);
        cell.setCellValue("创建时间");
        cell=row.createCell(9);
        cell.setCellValue("修改者");
        cell=row.createCell(10);
        cell.setCellValue("修改时间");

        //创建HSSFCellStyle对象，对应样式
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
//5.遍历activityList，显示数据行
        if(activityList!=null){
            Activity activity=null;
            for(int i=0;i<activityList.size();i++){
                activity=activityList.get(i);//获取每一条数据

                row=sheet.createRow(i+1);//创建一行

                cell=row.createCell(0);//column：列的编号,从0开始，0表示第一列，1表示第二列，....
                cell.setCellValue(activity.getId());
                cell=row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell=row.createCell(2);
                cell.setCellValue(activity.getName());
                cell=row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell=row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell=row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell=row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell=row.createCell(7);
                cell.setCellValue(activity.getCreateBy());
                cell=row.createCell(8);
                cell.setCellValue(activity.getCreateTime());
                cell=row.createCell(9);
                cell.setCellValue(activity.getEditBy());
                cell=row.createCell(10);
                cell.setCellValue(activity.getEditTime());
            }
        }
        //返回响应信息
        //1.设置响应类型
        response.setContentType("application/octet-stream;charset=UTF-8");
        //根据HTTP协议的规定，浏览器每次向服务器发送请求，都会把浏览器信息以请求头的形式发送到服务器
        String browser=request.getHeader("User-Agent");

        //不同的浏览器接收响应头采用的编码格式不一样：
        //IE采用 urlencoded
        ////火狐采用 ISO8859-1
        String fileName=URLEncoder.encode("市场活动列表","UTF-8");
        if(browser.contains("firefox")){
            //火狐采用 ISO8859-1
            fileName=new String("市场活动列表".getBytes("UTF-8"),"ISO8859-1");
        }

        //默认情况下，浏览器接收到响应信息之后，直接在显示窗口中打开；
        //可以设置响应头信息，使浏览器接收到响应信息之后，在下载窗口打开
        response.addHeader("Content-Disposition","attachment;filename="+fileName+".xls");
        //2.获取输出流
        OutputStream os2=response.getOutputStream();
        //3.把excel文件通过os2输出到客户端
        wb.write(os2);
        //4.关闭资源
        os2.flush();
        wb.close();
    }
    @RequestMapping("/workbench/activity/importActivity.do")
    public @ResponseBody Object importActivity(MultipartFile activityFile, HttpSession session){
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        Map<String,Object> retMap=new HashMap<>();
        try {
            //把activityFile保存到服务器磁盘上某一个位置
            //File file=new File("F:\\teaching\\section05\\server_testDir", activityFile.getOriginalFilename());
            //activityFile.transferTo(file);//效率低

            //解析excel文件，封装参数(activityList)
            //根据目标文件创建HSSFWorkbook对象，封装了文件中的所有数据

            List<Activity> activityList=new ArrayList<>();
            //InputStream is=new FileInputStream("F:\\teaching\\section05\\server_testDir\\"+activityFile.getOriginalFilename());
            InputStream is=activityFile.getInputStream();
            HSSFWorkbook wb=new HSSFWorkbook(is);//效率低
            //根据wb获取HSSFSheet对象，对应一页的数据
            HSSFSheet sheet=wb.getSheetAt(0);
            //根据sheet获取HSSFRow对象，对应一行的数据
            HSSFRow row=null;
            HSSFCell cell=null;
            Activity activity=null;
            for(int i=1;i<=sheet.getLastRowNum();i++){//sheet.getLastRowNum()：获取的是最后一行的编号
                row=sheet.getRow(i);
                //创建一个市场活动对象
                activity=new Activity();
                activity.setId(UUIDUtils.getUUID());
                activity.setOwner(user.getId());
                activity.setCreateBy(user.getId());
                activity.setCreateTime(DateUtils.formatDateTime(new Date()));

                //根据row获取HSSFCell对象，对应一列的数据
                for(int j=0;j<row.getLastCellNum();j++){//row.getLastCellNum()：获取的是最后一列的编号+1
                    cell=row.getCell(j);
                    String cellValue=getCellValue(cell);
                    if(j==0){
                        activity.setName(cellValue);
                    }else if(j==1){
                        activity.setStartDate(cellValue);
                    }else if(j==2){
                        activity.setEndDate(cellValue);
                    }else if(j==3){
                        activity.setCost(cellValue);
                    }else if(j==4){
                        activity.setDescription(cellValue);
                    }
                }

                //一行遍历完，都封装成了activity对象，把activity对象保存到list中
                activityList.add(activity);
            }

            //调用service层方法，保存数据
            int ret=activityService.saveCreateActivityByList(activityList);

            retMap.put("code",Contants.RETURN_OBJECT_CODE_SUCCESS);
            retMap.put("count",ret);
        }catch (Exception e){
            e.printStackTrace();
            retMap.put("code",Contants.RETURN_OBJECT_CODE_FAIL);
            retMap.put("chw","系统忙，请稍后重试...");
        }
        return retMap;
    }

    private String getCellValue(HSSFCell cell) {
        String ret="";
        /*if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
            ret=cell.getStringCellValue();
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
            ret=cell.getBooleanCellValue()+"";
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
            ret=cell.getNumericCellValue()+"";
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_FORMULA){
            ret=cell.getCellFormula();
        }else{
            ret="";
        }*/

        switch (cell.getCellType()){
            case HSSFCell.CELL_TYPE_STRING:
                ret=cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                ret=cell.getBooleanCellValue()+"";
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                ret=cell.getNumericCellValue()+"";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                ret=cell.getCellFormula();
                break;
            default:
                ret="";
        }
        return ret;
    }

    @RequestMapping("/workbench/activity/detailActivity.do")
    public String detailActivity(String id,Model model){
        //调用service层方法，查询数据
        Activity activity=activityService.queryActivityForDetailById(id);
        List<ActivityRemark> remarkList=activityRemarkService.queryActivityRemarkForDetailByActivityId(id);
        //把数据保存到request中
        model.addAttribute("activity",activity);
        model.addAttribute("remarkList",remarkList);
        //请求转发
        return "workbench/activity/detail";
    }

}
