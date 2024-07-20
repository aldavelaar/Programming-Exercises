<html>
<head>
<title>Random Quiz</title>
</head>
<body>
<h3>Random Quiz</h3>

<form action = "NewServlet"
method = "get">
<!-- Name text fields -->
<p>
    <input type = "number" name = "q" value = <%= 1 + (int)(Math.random() * ((9 - 1) + 1)) %> readonly="readonly"/>
    <label> + </label>
    <input type = "number" name = "u" value = <%= 1 + (int)(Math.random() * ((9 - 1) + 1)) %> readonly="readonly"/>
    <label> = </label>
    <input type = "number" name = "a" required = "required"/>
    <br>
    <input type = "number" name = "qq" value = <%= 1 + (int)(Math.random() * ((9 - 1) + 1)) %> readonly="readonly"/>
    <label> + </label>
    <input type = "number" name = "uu" value = <%= 1 + (int)(Math.random() * ((9 - 1) + 1)) %> readonly="readonly"/>
    <label> = </label>
    <input type = "number" name = "aa" required = "required"/>
    <br>
    <input type = "number" name = "qqq" value = <%= 1 + (int)(Math.random() * ((9 - 1) + 1)) %> readonly="readonly"/>
    <label> + </label>
    <input type = "number" name = "uuu" value = <%= 1 + (int)(Math.random() * ((9 - 1) + 1)) %> readonly="readonly"/>
    <label> = </label>
    <input type = "number" name = "aaa" required = "required"/>
    <br>
</p>

<!-- Submit and Reset buttons -->
<p><input type = "submit" value = "Submit" />
<input type = "reset" value = "Reset" />
<br><br>
<label>Click the browser's refresh button to get a new quiz</label></p>
</form>
</body>
</html>