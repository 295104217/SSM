<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/user/findAll" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${param.name}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="${param.address}" class="form-control" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" name="email" value="${param.email}"  class="form-control" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toAddUI">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" onclick="delSelected();">删除选中</a>

    </div>

    <form id="idForm" method="post" action="${pageContext.request.contextPath}/user/delSelected">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageBean.list}" varStatus="s" var="u">
                <tr>
                    <th><input type="checkbox" name="itemId" value="${u.id}"></th>
                    <td>${s.count}</td>
                    <td>${u.name}</td>
                    <td>${u.gender}</td>
                    <td>${u.age}</td>
                    <td>${u.province.name}</td>
                    <td>${u.qq}</td>
                    <td>${u.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/user/findById?id=${u.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:void(0);" onclick="delItem(${u.id})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pageBean.currentPage > 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/findAll?currentPage=${pageBean.currentPage - 1}&pageSize=${pageBean.pageSize}&name=${param.name}&email=${param.email}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.currentPage <= 1}">
                    <li class="disabled">
                        <a href="javascript:void(0); " aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>


                <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                    <c:if test="${i == pageBean.currentPage}">
                        <li class="active"><a href="javascript:void(0); ">${i}</a></li>
                    </c:if>
                    <c:if test="${i != pageBean.currentPage}">
                        <li><a href="${pageContext.request.contextPath}/user/findAll?currentPage=${i}&pageSize=${pageBean.pageSize}&name=${param.name}&email=${param.email}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${pageBean.currentPage < pageBean.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/findAll?currentPage=${pageBean.currentPage + 1}&pageSize=${pageBean.pageSize}&name=${param.name}&email=${param.email}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.currentPage >= pageBean.totalPage}">
                    <li class="disabled">
                        <a href="javascript:void(0);" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

                <span style="font-size: 25px;margin-left: 5px;">
                    共${pageBean.totalCount}条记录，共${pageBean.totalPage}页
                </span>

            </ul>
        </nav>


    </div>

</div>
<script>
    
    function delItem(id) {
        if(confirm("您确定要删除该条记录？")){
            location.href = "${pageContext.request.contextPath}/user/delete?id=" + id;
        }
    }
    
    function delSelected() {
        if(confirm("您确定要删除选中的记录？")){
            if($("input[name='itemId']:checked").length > 0){
                $("#idForm").submit()
            }else{
                alert("没有可用于删除的条目");
            }
        }
    }

</script>
</body>
</html>
