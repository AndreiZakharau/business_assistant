<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salesperson work</title>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="https://bootstraptema.ru/snippets/element/2020/bootstrap-table.css" rel="stylesheet" />
    <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://bootstraptema.ru/snippets/element/2020/bootstrap-table.js"></script>
</head>
<form action="/salesperson/salespersonWork" method="post">

<a>
    <button type="submit" class="ui-button" href="/salesperson/salespersonWork" >
<c:forEach var="orders" items="${requestScope.orders}">
    <input type="hidden" name="numberNew" value="${orders.number}">
</c:forEach>
        ORDER</button>
</a>
</form>
<div class="wrapper">
    <div class="flex">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">

                <div class="fresh-table toolbar-color-blue">

                    <!-- Изменение фона таблицы: full-color-blue, full-color-azure, full-color-green, full-color-red, full-color-orange
                    Изменение фона тулбара страницы: toolbar-color-blue, toolbar-color-azure, toolbar-color-green, toolbar-color-red, toolbar-color-orange
                    -->

                    <div class="toolbar">
                        <button id="alertBtn" class="btn btn-default">Alert</button>
                    </div>

                    <table id="fresh-table" class="table" >
                        <thead>

                            <th data-field="name" data-sortable="true">Product</th>
                            <th data-field="categories" data-sortable="true">Category</th>
                            <th data-field="suppliers_id" data-sortable="true">Supplier</th>
                            <th data-field="shop" data-sortable="true">Shop</th>
                            <th data-field="final price" data-sortable="true">Final price</th>
                            <th data-field="delivery" data-sortable="true">Delivery</th>
                            <th data-field="date expiration" data-sortable="true"></th>
                            <th data-field="date" data-sortable="true">Count</th>
                            <th></th>

                        </thead>
                        <tbody>

                        <c:forEach var="product" items="${requestScope.products}">
                            <tr>
                                <td>${product.name}</td>
                                <c:forEach var="categories" items="${requestScope.categories}">
                                    <c:if test="${categories.id==product.categories}">
                                        <td>${categories.category}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="suppliers_id" items="${requestScope.suppliers}">
                                    <c:if test="${suppliers_id.id==product.suppliers}">
                                        <td>${suppliers_id.nameSupplier}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="shop" items="${requestScope.shops}">
                                    <c:if test="${shop.id==product.shop}">
                                        <td>${shop.nameShop}</td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="categories" items="${requestScope.categories}">
                                    <c:if test="${categories.id==product.categories}">
                                        <td><fmt:formatNumber value="${product.price +(product.price * categories.interest / 100)}" maxFractionDigits="2"/></td>
                                    </c:if>
                                </c:forEach>
                                <td>${product.localDate}</td>
                                <td>${product.date}</td>
                                <td>${product.count}</td>
                                <td>

                                <form action="/salesperson/salespersonWork" method="post">
                                  <input type="hidden" name="id" value="${product.id}">
                                  <input type="hidden" name="name" value="${product.name}">
                                  <input type="hidden" name="categories_id" value="${product.categories}">
                                  <input type="hidden" name="suppliers_id" value="${product.suppliers}">
                                  <input type="hidden" name="shop_id" value="${product.shop}">
                                  <input type="hidden" name="price" value="${product.price}">
                                  <input type="hidden" name="delivery" value="${product.localDate}">
                                  <input type="hidden" name="date_expiration" value="${product.date}">
                                  <input type="hidden" name="count" value="${product.count}">
                                    <c:forEach var="categories" items="${requestScope.categories}">
                                        <c:if test="${categories.id==product.categories}">
                                            <input type="hidden" name="interest" value="${categories.interest}">
                                        </c:if>
                                    </c:forEach>
                                    <input type="hidden" name="nameSalesperson" value="${sessionScope.lastName}">
                                    <c:forEach var="shops" items="${requestScope.shops}">
                                        <c:if test="${shops.id==product.shop}">
                                            <input type="hidden" name="nameShop" value="${shops.nameShop}">
                                        </c:if>
                                    </c:forEach>
                                  <c:forEach var="orders" items="${requestScope.orders}">
                                  <input type="hidden" name="number" value="${orders.number}">
                                      <c:if test="${product.name==orders.product}">
                                      <input type="hidden" name="product" value="${orders.product}">
                                      <c:if test="${product.id==orders.id}">
                                  <input type="hidden" name="idOrder" value="${orders.id}">
                                      </c:if>

<%--                                  <input type="hidden" name="product" value="${product.name}">--%>
<%--                                  <input type="hidden" name="localDate" value="${orders.localDate}">--%>
<%--                                  <input type="hidden" name="sum" value="${orders.sum}">--%>
                                  <input type="hidden" name="quantum" value="${orders.quantum}">
                                  </c:if>



                                  </c:forEach>
                                  <button type="submit" class="W3">-</button>
                                </form>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>


                    </table>
                </div>
               <a type="submit" class="ui-button" href="/salesperson/salesperson_menu.jsp">Exit</a>
            </div>
        </div>
    </div>
</div>

<script>
    var $table = $('#fresh-table'),
        $alertBtn = $('#alertBtn'),
        full_screen = false;

    $().ready(function(){
        $table.bootstrapTable({
            toolbar: ".toolbar",

            showRefresh: true,
            search: true,
            showToggle: true,
            showColumns: true,
            pagination: true,
            striped: true,
            pageSize: 8,
            pageList: [8,10,25,50,100],

            formatShowingRows: function(pageFrom, pageTo, totalRows){
                //do nothing here, we don't want to show the text "showing x of y from..."
            },
            formatRecordsPerPage: function(pageNumber){
                return pageNumber + " rows visible";
            },
            icons: {
                refresh: 'fa fa-refresh',
                toggle: 'fa fa-th-list',
                columns: 'fa fa-columns',
                detailOpen: 'fa fa-plus-circle',
                detailClose: 'fa fa-minus-circle'
            }
        });



        $(window).resize(function () {
            $table.bootstrapTable('resetView');
        });


        window.operateEvents = {
            'click .like': function (e, value, row, index) {
                alert('You click like icon, row: ' + JSON.stringify(row));
                console.log(value, row, index);
            },
            'click .edit': function (e, value, row, index) {
                alert('You click edit icon, row: ' + JSON.stringify(row));
                console.log(value, row, index);
            },
            'click .remove': function (e, value, row, index) {
                $table.bootstrapTable('remove', {
                    field: 'id',
                    values: [row.id]
                });

            }
        };

        $alertBtn.click(function () {
            alert("You pressed on Alert");
        });

    });


    function operateFormatter(value, row, index) {
        return [
            '<a rel="tooltip" title="Like" class="table-action like" href="javascript:void(0)" title="Like">',
            '<i class="fa fa-heart"></i>',
            '</a>',
            '<a rel="tooltip" title="Edit" class="table-action edit" href="javascript:void(0)" title="Edit">',
            '<i class="fa fa-edit"></i>',
            '</a>',
            '<a rel="tooltip" title="Remove" class="table-action remove" href="javascript:void(0)" title="Remove">',
            '<i class="fa fa-remove"></i>',
            '</a>'
        ].join('');
    }


</script>

</html>