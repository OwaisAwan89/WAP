<%--
  Created by IntelliJ IDEA.
  User: bishwasmishra
  Date: 11/05/20
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>


<%--
  Created by IntelliJ IDEA.
  User: Owais Awan
  Date: 5/10/2020
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/all.css" >
    <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/sb-admin-2.css" >
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@include file="/WEB-INF/fragments/header.jsp"%>

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Bill Pay</h1>
        </div>

        <div class="row">

            <div class="col-lg-6">
                <!-- Collapsable Card Example -->
                <div class="card shadow mb-4">
                    <!-- Card Header - Accordion -->
                    <a href="#collapseCardExample1" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-controls="collapseCardExample">
                        <h6 class="m-0 font-weight-bold text-primary">Water Bill </h6>
                    </a>
                    <!-- Card Content - Collapse -->
                    <div class="collapse" id="collapseCardExample1">
                        <div class="card-body">
                            Water Incorporation
                            <br> BENEFICIARY BANK: Wells Fargo Bank
                            <br> BENEFICIARY ACCOUNT NUMBER: B1801111555
                            <br><br>

                            <form class="user">
                                <div class="input-group">

                                    <div class="input-group-append">
                                        <input type="text" name ="billNumber" class="form-control bg-light border-0 small" placeholder="Enter bill Number" aria-label="Search" aria-describedby="basic-addon2">
                                        <button class="btn btn-primary btn-user btn-block">Generate Bill</button>
                                    </div>

                                </div>
                            </form>
                            <form class="form-inline float-left" method="POST" action="billPay">
                                <label class="my-1 mr-2" for="account">Account:</label>
                                <select class="custom-select my-1 mr-sm-2" id="account">
                                    <option selected>Choose your account</option>
                                    <c:forEach var="acc" items="${myAccounts}">
                                        <option
                                                value="<c:out value="${acc.accountNumber}"/>"
                                                <c:if test="${account==acc.accountNumber}">selected</c:if> >
                                            <c:out value="${acc.user.firstName} ${acc.user.lastName} | ${acc.accountType} | ${acc.accountNumber}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                                <br>
                                <input type="hidden" name="billNumber" value="11111">
                                <input type="hidden" name="account_number" value="1">
                                <input type="hidden" name="beneficiary" value="Water Incorporation">
                                <input type="hidden" name="bank" value="Wells Fargo Bank">
                                <input type="hidden" name="bank-account-number" value="B1801111555">
                                <button name="billPay" class="btn btn-primary btn-user btn-block">Pay</button>
                            </form>
                            <p style="visibility: hidden">$5.00 <button class="btn btn-primary" type="button"></button></p>

                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <!-- Collapsable Card Example -->
                <div class="card shadow mb-4">
                    <!-- Card Header - Accordion -->
                    <a href="#collapseCardExample2" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-controls="collapseCardExample">
                        <h6 class="m-0 font-weight-bold text-primary">Electricity Bill</h6>
                    </a>
                    <!-- Card Content - Collapse -->
                    <div class="collapse" id="collapseCardExample2">
                        <div class="card-body">
                            Tesla Pvt. Ltd.
                            <br> BENEFICIARY BANK: Mid West One Bank
                            <br> BENEFICIARY ACCOUNT NUMBER: PQR01111555
                            <br><br>

                            <form class="user" method="POST" action="billPay">
                                <div class="input-group">

                                    <div class="input-group-append">
                                        <input type="text" name ="billNumber" class="form-control bg-light border-0 small" placeholder="Enter bill Number" aria-label="Search" aria-describedby="basic-addon2">
                                        <input type="hidden" name="beneficiary" value="Tesla Pvt. Ltd.">
                                        <input type="hidden" name="bank" value="Mid West Bank">
                                        <button class="btn btn-primary btn-user btn-block">Generate Bill</button>
                                    </div>

                                </div>
                            </form>

                            <p style="visibility: hidden">$5.00 <button class="btn btn-primary" type="button"></button></p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <!-- Collapsable Card Example -->
                <div class="card shadow mb-4">
                    <!-- Card Header - Accordion -->
                    <a href="#collapseCardExample3" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-controls="collapseCardExample">
                        <h6 class="m-0 font-weight-bold text-primary">Credit Card Bill</h6>
                    </a>
                    <!-- Card Content - Collapse -->
                    <div class="collapse" id="collapseCardExample3">
                        <div class="card-body">
                            Discovery
                            <br> BENEFICIARY BANK: Mid West One Bank
                            <br> BENEFICIARY ACCOUNT NUMBER: ACC01111555
                            <br><br>

                            <form class="user" method="POST" action="billPay">
                                <div class="input-group">

                                    <div class="input-group-append">
                                        <input type="text" name ="billNumber" class="form-control bg-light border-0 small" placeholder="Enter bill Number" aria-label="Search" aria-describedby="basic-addon2">
                                        <input type="hidden" name="beneficiary" value="Discovery">
                                        <input type="hidden" name="bank" value="Mid West One Bank">
                                        <button class="btn btn-primary btn-user btn-block">Generate Bill</button>
                                    </div>

                                </div>
                            </form>

                            <p style="visibility: hidden">$5.00 <button class="btn btn-primary" type="button"></button></p>

                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login">Logout</a>
            </div>
        </div>
    </div>
</div>

<script src="<%=application.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%=application.getContextPath() %>/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="<%=application.getContextPath() %>/js/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="<%=application.getContextPath() %>/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="<%=application.getContextPath() %>/js/chart.min.js"></script>


</body>

</html>
</html>