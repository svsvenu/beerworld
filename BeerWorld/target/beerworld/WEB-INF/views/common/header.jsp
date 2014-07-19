<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add Address</title>
    <link rel="stylesheet" href="resources/js/dropdown-menu.css" />
<script type="text/javascript" src="resources/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="resources/js/dropdown-menu.min.js"></script>
<script type="text/javascript">
$(function() {
    $('.dropdown-menu').dropdown_menu();
}); 
</script>
</head>
<body>
	
	<ul class="dropdown-menu">
    <li><a href="/beerworld">Home</a></li>
    <li>
        <a href="#">Item 2</a>
        <ul>
            <li>
                <a href="#">Submenu Item</a>
                <ul>
                    <li><a href="/home">Submenu Item 1</a></li>
                    <li><a href="#">Submenu Item 2</a></li>
                </ul>
            </li>
        </ul>
    </li>
</ul>
</body>
</html>