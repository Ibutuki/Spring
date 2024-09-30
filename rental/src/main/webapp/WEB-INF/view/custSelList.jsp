<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員一覧</title>
    <link rel="stylesheet" href="static/css/layui.css">
    <link rel="stylesheet" href="static/css/view.css">
    <link rel="icon" href="static/images/r.ico">
</head> 
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>会員検索</a>
                  <a><cite>会員一覧</cite></a>
                </span>
                <h2 class="title">会員一覧</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
					<table id="custListTable" lay-filter="custListTable">
						<!-- 検索結果のリスト -->
					</table>
                    <div class="layui-form-item">
						<label class="layui-form-label">&nbsp;</label>
						<button type="button" class="layui-btn layui-btn-blue" onclick="backToSelForm()">会員検索</button>
					</div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="static/layui.all.js" charset='UTF-8'></script>
    <script src="static/js/home.js"></script>
    <!-- 操作列 -->
    <script type="text/html" id="detailBar">
        <a class="layui-btn layui-btn-xs" lay-event="detail">詳細</a>
    </script>
    
    <script>
	    layui.use(['form', 'table', 'layer', 'element'], function(){
	        var form = layui.form;
	        var table = layui.table;
	        var layer = layui.layer;
	        var element = layui.element;
	
	        // json形式の検索結果リストを取得する
	        var customerList = <%= request.getAttribute("jsonCustList")%>;
	
	        // 表示が必要なデータを処理する
	        var processedList = customerList.map(function(customer) {
	        	var delFlagText = customer.delFlag == 0 ? '会員' : '退会者';
	            return {
	                memId: customer.memId,
	                fullname: customer.lastname + ' ' + customer.firstname,
	                fullkana: customer.lastkana + ' ' + customer.firstkana,
	                tel: customer.tel1 + '-' + customer.tel2 + '-' + customer.tel3,
	                delFlag: delFlagText
	            };
	        });
	
	        // テーブルをレンダリングする
	        table.render({
	            elem: '#custListTable',
	            cols: [[
	                {field: 'memId', title: '会員ID', width: 200, sort: true},
	                {field: 'fullname', title: '氏名', width: 200, sort: true},
	                {field: 'fullkana', title: '氏名カナ', minWidth: 200, sort: true},
	                {field: 'tel', title: '電話番号', width: 200, sort: true},
	                {field: 'delFlag', title: '会員状況', width: 200, sort: true},
	                {fixed: 'right', title: '操作', toolbar: '#detailBar', width: 80}
	            ]],
	            data: processedList, // 処理された会員リストデータ
	            skin: 'line', // テーブルスタイル
	            even: true,
	            page: true, // ページングを有効にする
	            limit: 10, // 一ページあたり10件で表示する
	            limits: [10,20,30]
	        });
	        table.reload('custListTable');
	     	
			// テーブル内の操作イベントを監視する
	        table.on('tool(custListTable)', function(obj) {
	            var data = obj.data;
	            if(obj.event === 'detail'){
	                // 会員詳細情報ページに遷移し、会員IDパラメーターを渡す
	                window.location.href = 'toCustSelDetails?memId=' + data.memId;
	            }
	        });
	    });
	    /*
			検索フォームに遷移する
		*/
		function backToSelForm() {
		    window.location.href = "${pageContext.request.contextPath}/custSelForm";
		}
    </script>
    
    
    
</body>
</html>