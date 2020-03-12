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
					<form:form method="post" action= "/customer/buy_now" modelAttribute="order" >
					<tr>
						<td>${product.code}</td>
    					<td>${product.name}</td>
    					<td>${product.price}</td>
    					 <td><img class="img-thumbnail" width="100" height="80" src="/get_image?code=${product.code}" /></td>
    					 <td><select id="quantity" name = "quantity">
                               <option value="">Please select</option>
                               <option value="1">1</option>
                               <option value="2">2</option>
                               <option value="3">3</option>
                               <option value="4">4</option>
                             </select>
                             <br>
                             Suggest changes to Product <br>
                             <input type = "textarea" name = "comment">

                         </td>
                            <input type="hidden" name="pcode" value = ${product.code}>
                         <td><button type="submit" class="btn btn-success">Buy Now</button></td>

					</tr>
					</form:form>
				</c:forEach>
			</tbody>
		</table>


	</div>


<%@ include file="common/footer.jspf" %>