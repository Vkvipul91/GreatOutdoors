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
					<th>Quantity</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>

					<tr>
						<td>${product.code}</td>
    					<td>${product.name}</td>
    					<td>${product.price}</td>
    					<td>${order.quantity}</td>
    					<td>${order.bill}</td>
    					<td></td>

					</tr>

			</tbody>
		</table>
		<div class="container">




        		<fieldset class="form-group">
                				<form:label path="customerName">Customer Name</form:label>
                				<form:input path="customerName" type="text"
                					class="form-control" required="required"/>
                				<form:errors path="customerName" cssClass="text-warning"/>
                			</fieldset>
                <fieldset class="form-group">
                        				<form:label path="customerAddress">Customer Address</form:label>
                        				<form:input path="customerAddress" type="text"
                        					class="form-control" required="required"/>
                        				<form:errors path="customerAddress" cssClass="text-warning"/>
                        			</fieldset>
                <fieldset class="form-group">
                        				<form:label path="customerEmail">customer Email</form:label>
                        				<form:input path="customerEmail" type="text"
                        					class="form-control" required="required"/>
                        				<form:errors path="customerEmail" cssClass="text-warning"/>
                        			</fieldset>
                <fieldset class="form-group">
                        				<form:label path="customerPhone">customer Phone</form:label>
                        				<form:input path="customerPhone" type="text"
                        					class="form-control" required="required"/>
                        				<form:errors path="customerPhone" cssClass="text-warning"/>
                        			</fieldset>

              <input type="hidden" name="name" value = ${product.code}>
              <input type="hidden" name="quantity" value = ${order.quantity}>
              <input type="hidden" name="bill" value = ${order.bill}>


        			<button type="submit" class="btn btn-success">Place Order</button>

        	</div>
</form:form>
	</div>
<%@ include file="common/footer.jspf" %>