<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />

	<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
	<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

	<!--  PAGINATION plugin -->
	<link rel="stylesheet" type="text/css" href="jquery/bs_pagination-master/css/jquery.bs_pagination.min.css">
	<script type="text/javascript" src="jquery/bs_pagination-master/js/jquery.bs_pagination.min.js"></script>
	<script type="text/javascript" src="jquery/bs_pagination-master/localization/en.js"></script>
	<script type="text/javascript">
	$(function(){

		//给"创建"按钮添加单击事件
		$("#createTranBtn").click(function () {
			//发送同步请求
			window.location.href="workbench/transaction/createTran.do";
		});
		queryTransctionForPageByCondition(1,10);

		$("#check-btn").click(function () {
			//显示所有符合条件的数据的第一页，默认每页显示10条
			queryTransctionForPageByCondition(1,$("#demo_pag1").bs_pagination('getOption', 'rowsPerPage'));
		})

	});

		function queryTransctionForPageByCondition(pageNo,pageSize) {
			//收集参数
			//var pageNo=1;
			//var pageSize=10;

			var transctionOwner=$("#check-owner").val();
			var transctionname =$("#check-name").val();
			var transctioncustomerName =$("#check-customerName").val();
			var transctionstate =$("#check-state").val();
			var transctionkinds =$("#check-kinds").val();
			var transctionSource =$("#check-Source").val();
			var transctionconstacts =$("#check-constacts").val();
			//发送请求
			$.ajax({
				url:'workbench/transaction/queryTranForPageByCondition.do',
				data:{
					pageNo:pageNo,
					pageSize:pageSize,
					transctionOwner:transctionOwner,
					transctionname:transctionname,
					transctioncustomerName:transctioncustomerName,
					transctionstate:transctionstate,
					transctionkinds:transctionkinds,
					transctionSource:transctionSource,
					transctionconstacts:transctionconstacts
				},
				type:'post',
				dataType:'json',
				success:function (data) {
					var htmlStr="";
					$.each(data.tranList,function (index,obj) {
						htmlStr+="<tr class=\"active\">";
						htmlStr+="<td><input type=\"checkbox\"  value=\""+obj.id+"\"/></td>";
						htmlStr+="<td><a style=\"text-decoration: none; cursor: pointer;\" onclick=\"window.location.href='workbench/transaction/detailTransacttion.do?id="+obj.id+"'\">"+obj.name+"</a></td>";
						htmlStr+="<td>"+obj.customername+"</td>";
						htmlStr+="<td>"+obj.stage+"</td>";
						htmlStr+="<td>"+obj.type+"</td>";
						htmlStr+="<td>"+obj.owner+"</td>";
						htmlStr+="<td>"+obj.source+"</td>";
						htmlStr+="<td>"+obj.contactsName+"</td>";
						htmlStr+="</tr>";
						/*<tr class="active">
					<td><input type="checkbox" /></td>
					<td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='detail.jsp';">动力节点-交易01</a></td>
					<td>动力节点</td>
					<td>谈判/复审</td>
					<td>新业务</td>
					<td>zhangsan</td>
					<td>广告</td>
					<td>李四</td>
				</tr>*/
					});

					//把htmlStr显示在tbody
					$("#tBody").html(htmlStr);

					//计算总页数
					var totalPages=1;
					if (data.totalRows%pageSize==0){
						totalPages=data.totalRows/pageSize;
					}else{
						totalPages=parseInt(data.totalRows/pageSize)+1;
					}

					//显示翻页信息
					$("#demo_pag1").bs_pagination({
						currentPage:pageNo,//当前页

						rowsPerPage:pageSize,//每页显示条数
						totalRows:data.totalRows,//总条数
						totalPages: totalPages,//总页数

						visiblePageLinks:5,//显示的翻页卡片数

						showGoToPage:true,//是否显示"跳转到第几页"
						showRowsPerPage:true,//是否显示"每页显示条数"
						showRowsInfo:true,//是否显示"记录的信息"

						//每次切换页号都会自动触发此函数，函数能够返回切换之后的页号和每页显示条数
						onChangePage: function(e,pageObj) { // returns page_num and rows_per_page after a link has clicked
							//alert(pageObj.currentPage);
							//alert(pageObj.rowsPerPage);
							queryTransctionForPageByCondition(pageObj.currentPage,pageObj.rowsPerPage);

						}
					});

				}
			});
		}
	
</script>
</head>
<body>



<div>
	<div style="position: relative; left: 10px; top: -10px;">
		<div class="page-header">
			<h3>交易列表</h3>
		</div>
	</div>
</div>

<div style="position: relative; top: -20px; left: 0px; width: 100%; height: 100%;">

	<div style="width: 100%; position: absolute;top: 5px; left: 10px;">

		<div class="btn-toolbar" role="toolbar" style="height: 80px;">
			<form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">所有者</div>
						<input class="form-control" type="text" id="check-owner">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">名称</div>
						<input class="form-control" type="text" id="check-name">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">客户名称</div>
						<input class="form-control" type="text" id="check-customerName">
					</div>
				</div>

				<br>

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">阶段</div>
						<select class="form-control" id="check-state">
							<option></option>
							<c:forEach items="${stageList}" var="s">
								<option value="${s.id}">${s.value}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">类型</div>
						<select class="form-control" id="check-kinds">
							<option></option>
							<c:forEach items="${transactionTypeList}" var="tt">
								<option value="${tt.id}">${tt.value}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">来源</div>
						<select class="form-control" id="check-Source">
							<option></option>
							<c:forEach items="${sourceList}" var="so">
								<option value="${so.id}">${so.value}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">联系人名称</div>
						<input class="form-control" type="text" id="check-constacts">
					</div>
				</div>

				<button type="submit" class="btn btn-default" id="check-btn">查询</button>

			</form>
		</div>
		<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 10px;">
			<div class="btn-group" style="position: relative; top: 18%;">
				<button id="createTranBtn" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> 创建</button>
				<button type="button" class="btn btn-default" onclick="window.location.href='edit.jsp';"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
				<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除</button>
			</div>


		</div>
		<div style="position: relative;top: 10px;">
			<table class="table table-hover">
				<thead>
				<tr style="color: #B3B3B3;">
					<td><input type="checkbox" /></td>
					<td>名称</td>
					<td>客户名称</td>
					<td>阶段</td>
					<td>类型</td>
					<td>所有者</td>
					<td>来源</td>
					<td>联系人名称</td>
				</tr>
				</thead>
				<tbody id="tBody">
				<%--
				<tr class="active">
					<td><input type="checkbox" /></td>
					<td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='detail.jsp';">动力节点-交易01</a></td>
					<td>动力节点</td>
					<td>谈判/复审</td>
					<td>新业务</td>
					<td>zhangsan</td>
					<td>广告</td>
					<td>李四</td>
				</tr>--%>
				</tbody>
			</table>
			<div id="demo_pag1"></div>
		</div>

	</div>

</div>
</body>
</html>