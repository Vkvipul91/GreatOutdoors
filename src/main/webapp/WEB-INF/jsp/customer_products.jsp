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
    					 <td><select id="quantity">
                               <option value="1">1</option>
                               <option value="2">2</option>
                               <option value="3">3</option>
                               <option value="4">4</option>
                             </select>
                         </td>
                         <td><a type="button" class="btn btn-warning" href="/buy_now?code=${product.code}">Buy Now</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


<%@ include file="common/footer.jspf" %>