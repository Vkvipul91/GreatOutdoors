<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<table class="table">
			<caption>My Orders:</caption>
			<thead>
				<tr class="active">
					<th>Order No</th>
					<th>Name</th>
					<th>Price</th>
					<th>Updated At</th>
				</tr>
			</thead>
            <tbody>
				<c:forEach items="${orderHistory}" var="order">
					<tr>
						<td>${order.id}</td>
    					<td>${order.orderDate}</td>
    					<td>${order.quantity}</td>
    					<td>${order.bill}</td>
    					<td>${order.customerName}</td>
    					<td>${order.customerAddress}</td>
    					<td>${order.customerEmail}</td>
    					<td>${order.customerPhone}</td>
    					<td>${order.product.name}</td>
    					<td>${order.product.price}</td>
    					<td>${order.status}</td>

						</tr>
				</c:forEach>
			</tbody>
		</table>

</div>


<%@ include file="common/footer.jspf" %>