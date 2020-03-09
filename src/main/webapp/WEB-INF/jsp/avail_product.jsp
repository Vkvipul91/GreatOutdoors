<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
		<table class="table table-striped">
			<caption>Available Products:</caption>
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Price</th>
					<th>Updated At</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.code}</td>
    					<td>${product.name}</td>
    					<td>${product.price}</td>
    					 <td><img class="img-thumbnail" width="100" height="80" src="/get_image?code=${product.code}" /></td>

						<td><a type="button" class="btn btn-success"
							href="/update_product?id=${product.code}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete_product?id=${product.code}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div> <a class="button" href="/admin/new_product">Add a Todo</a></div>
	</div>
<%@ include file="common/footer.jspf" %>