<%@ include file="common/header.jspf" %>
<%@ include file="common/admin_navigation.jspf" %>


<div class = "container">
<div class="dropdown">
   <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
      <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="/admin/view_Last_Week?id=${order.id}">View Last Day</a></li>
    <li><a href="#">View Last Week</a></li>
    <li><a href="#">View Last Month</a></li>
    <li><a href="#">Custom Dates</a></li>
  </ul>
</div>

<table class="table table-striped">
			<caption>Completed Order Report:</caption>
			<thead>
				<tr>
					<th>Order ID</th>
					<th>Date of Purchase</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Order Quantity</th>
					<th>Order Amount</th>
					<th>Customer Name</th>
					<th>Customer Address</th>
					<th>Order Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${orderCompletedList}" var="order">
            <tr>
			        <td>${order.id}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.product.name}</td>
                    <td>${order.product.price}</td>
                    <td>${order.quantity}</td>
                    <td>${order.bill}</td>
                    <td>${order.customerName}</td>
                    <td>${order.customerAddress}</td>
                    <td>${order.status}</td>
                    <td><a type="button" class="btn btn-success" href="/update_product?id=${order.id}">Modify</a></td>
                    <td><a type="button" class="btn btn-warning" href="/update_product?id=${order.id}">Cancel</a></td>
             </tr>
            </c:forEach>
            </tbody>
            </table>


</div>
<%@ include file="common/footer.jspf" %>