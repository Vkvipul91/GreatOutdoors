<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<form:form method="post"  action = "/place_order" modelAttribute="order">
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

					<tr>
						<td>${product.code}</td>
    					<td>${product.name}</td>
    					<td>${product.price}</td>

					</tr>

			</tbody>
		</table>
		<div class="container">




        		<fieldset class="form-group">
                				<form:label path="customerName">Customer_Name</form:label>
                				<form:input path="customerName" type="text"
                					class="form-control" required="required"/>
                				<form:errors path="customerName" cssClass="text-warning"/>
                			</fieldset>

              <input type="hidden" name="name" value = ${product.code}>


        			<button type="submit" class="btn btn-success">Place Order</button>

        	</div>
</form:form>
	</div>
<%@ include file="common/footer.jspf" %>