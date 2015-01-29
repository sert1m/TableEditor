
function getSelectedRows() {
	var checkboxes = document.getElementsByName("character");
	var checked = [];
	for (var i = 0; i < checkboxes.length; i++)
		if (checkboxes[i].checked) {
			checked.push(checkboxes[i]);
		}
	return checked;
}

function deleteCharacter() {
	var checked = getSelectedRows();	 
	if (checked.length == 0 ) {
		alert("No elements selected!");
		return;
	}
	
	params = {};
	for (var i = 0; i < checked.length; i++)
		params ["id" + i] = checked[i].value;

	$$a({
		type: "get",
		url: "delete",
		data: params,
		response: "text",
		success: function(data) {
			deleteFromTable();
		}
	})
}

function deleteFromTable() {	
	var table = document.getElementById("tbl");
	var checked = getSelectedRows();

	for (var i = 0; i < checked.length; i++)
		if (checked[i].checked) {
			var row = checked[i].parentNode.parentNode;
			table.deleteRow(row.rowIndex);
		}
} 

function editCharacter() {
	var checked = getSelectedRows();
	if (checked.length > 1) {
		alert("please select just one row to be edited");
		return;
	} 
	else if (checked.length == 1) {
		document.location.href = "edit.jsp?id=" + checked[0].value;
	}
	else if(checked.length == 0) {
		document.location.href = "edit.jsp"
	} 
	
}