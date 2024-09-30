<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
<script>
function calculateTotalPrice() {
    var totalPrice = 0;
    
    // 遍历每一行<tr>
    $('table tbody tr').each(function() {
        var price = parseFloat($(this).find('td:eq(2)').text()); // 获取单
        var quantity = parseInt($(this).find('td:eq(3)').text()); // 获取数量
         
        // 计算单行总金额并累加到总和
        var lineTotal = price * quantity;
        console.log(lineTotal);
        $(this).find('td:eq(4)').text(lineTotal.toFixed(2));
        totalPrice += lineTotal;
    });

    console.log('总金额:', totalPrice);
    $('#totalPrice').text(totalPrice.toFixed(2)); // 显示总金额，保留两位小数
}
function setInputValue(){
	 $('table tbody tr').each(function(){
		 var quantity = parseInt($(this).find('td:eq(3)').text());
		 console.log("数量："+quantity);
		 $(this).find('td:eq(5) input').val(quantity);
	 });
}
$(document).ready(function() {
    // 点击修改按钮时
    $(".edit").click(function() {
        // 获取当前行的第一个单元格（假设这里只修改第一个单元格）
        var td = $(this).closest('tr').find('td:eq(3)');
        // 获取单元格当前的文本内容
        var currentValue = td.text().trim();
        
        // 创建一个输入框，并设置输入框的值为当前单元格的内容
        var input = $('<input>').attr({
            type: 'text',
            value: currentValue
        });
        
        // 将输入框替换为单元格内的文本
        td.html(input);
        
        // 当输入框失去焦点时，保存修改
        input.focus().blur(function() {
            // 获取输入框的新值
            var newValue = $(this).val().trim();
            // 将新值设置回单元格
            td.text(newValue);
            calculateTotalPrice();
            setInputValue();
        });
       
    });
    calculateTotalPrice();
    setInputValue();
});
</script>
</head>
<body>
<form action="CarAction_buy" method="post">
<input type="submit" value="提交"/>
<table>
	<thead>
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
			<th>总金额</th>
			<th>操作</th>
		</tr>
	</thead>
	<c:set var="total" value="0"/>
	<tbody>
		<c:forEach var="detail" items="${tempDetailList }" varStatus="status">
			<tr data-id=${detail.shopId }>
				<td><input type="hidden" value="${detail.shopId }" name="shopId"/>${status.index+1 }</td>
				<td>${detail.shopInfo.shopName }</td>
				<td>${detail.shopInfo.price }</td>
				<td>${detail.quantity }</td>
				<td class="price"></td>
				<td><input type="hidden" name="quantity"/><a href="CarAction_deleteById?id=${status.index }">退货商品</a>&nbsp;&nbsp;<a href="#" class="edit">修改数量</a></td>
			</tr>
			<c:set var="total" value="${total + detail.totalPrice}"/> <!-- 更新total值 -->
		</c:forEach>
	</tbody>
</table>

</form>
<p>购物车总金额：￥<span id="totalPrice"></span></p>
	<a href="CarAction_clearCar">清空购物车</a>
</body>
</html>