<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<body>

<h2>member Join 3</h2>
<h3>'application/x-www-form-urlencoded'으로 보내고, json으로 받기</h3>

<form action="${pageContext.request.contextPath}/member/join3" method="post" id="memberJoinBizFrm">
    <input type="text" name="email" value="kjg@kjg.kjg"><br>
    <input type="text" name="name" value="kjg"><br>
<%--    <input type="submit" value="sbm"><br>--%>
    <input type="button" id="btnSubmit" value="sbm"><br>
</form>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
$(() => {
    $("body").on("click", "#btnSubmit", () => {
        let $frm = $("#memberJoinBizFrm");
        let data = $frm.serialize();
        console.info("## data: ", data);
        $.ajax({
            url: $frm.attr("action"),
            method: $frm.attr("method"),
            data: data,
            success: (res) => {
                console.info(res)
            }
        })
    });
});
</script>

</body>
</html>