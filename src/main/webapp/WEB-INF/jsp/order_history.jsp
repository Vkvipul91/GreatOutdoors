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
    					<td>${order.Customer.id}</td>
    					<td>${order.Customer.name}</td>
    					 <td><img class="img-thumbnail" width="100" height="80" src="/get_image?code=${product.code}" /></td>

						<td><a type="button" class="btn btn-success"
							href="/update_product?id=${product.code}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete_product?id=${product.code}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</div>


<%@ include file="common/footer.jspf" %>