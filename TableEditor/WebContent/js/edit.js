
function send (param) {
	param ["id"] = document.getElementById("id").innerHTML;
	param ["firstName"] = document.getElementById("firstName").value;
	param ["lastName"] = document.getElementById("lastName").value;
	var select = document.getElementById("sex");
	param ["sex"] = select.options[select.selectedIndex].text;
	param ["date"] = document.getElementById("date").value;
	param ["job"] = document.getElementById("job").value;
	param ["salary"] = document.getElementById("salary").value;
	$$a({
		type: "get",
		url: "edit",
		data: param,
		response: "text",
		success: function(data) {
			if (data != "")
				test(data);
			else
				document.location.href = "table.jsp";
		}
//		endstatus: function(number) {
//			test(number);
//		}
	});
}

function save() {

	var param = {};
	param ["type"] = "save";
	send(param);
}

function add() {

	var param = {};
	param ["type"] = "add";
	send(param);
}

function test(data) {
	alert(data);
}