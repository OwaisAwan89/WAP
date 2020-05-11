<!doctype html>
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

    <title>Transaction History</title>
</head>
<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@include file="/WEB-INF/fragments/header.jsp"%>

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Transaction History</h1>
        </div>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Target Account</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Create Time</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
            <tfoot>

            </tfoot>
        </table>

        <!-- Footer -->
        <%@include file="/WEB-INF/fragments/footer.jsp"%>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<%@include file="/WEB-INF/fragments/jsSetUp.jsp"%>
<script>

</script>
</body>
</html>