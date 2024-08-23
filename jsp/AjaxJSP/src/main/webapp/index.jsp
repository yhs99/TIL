<%@page import="java.sql.Connection"%>
<%@page import="com.ajaxjsp.dao.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<title>Insert title here</title>
<script type="text/javascript">
	let empData = null;
	let jobData = null;
	let deptData = null;
	$(document).ready(function() {
		getAllEmployees();
		getAllJobs();
		getAllDepartments();

		$("#job_id").change(function() {
			makeSalInput($(this).val(), "write");
		})
		$("#m_job_id").change(function() {
			makeSalInput($(this).val(), "modify");
		})
		
		$("#salary").change(function() {
			$("#salary_display").html($(this).val());
		})
		$("#m_salary").change(function() {
			$("#m_salary_display").html($(this).val());
		})
		
		$(".writeBtn").click(function() {
			let last_name = $("#last_name").val();
			let first_name = $("#first_name").val();
			let email = $("#email").val();
			let phone_number = $("#phone_number").val();
			let hire_date = $("#hire_date").val();
			let job_id = $("#job_id").val();
			let salary = $("#salary").val();
			let commission_pct = $("#commission_pct").val();
			let manager_id = $("#manager_id").val();
			let department_id = $("#department_id").val();
			let data = {
				last_name: last_name,
				first_name: first_name,
				email: email,
				phone_number: phone_number,
				hire_date: hire_date,
				job_id: job_id,
				salary: salary,
				commission_pct: commission_pct=="" ? 0 : commission_pct,
				manager_id: manager_id,
				department_id: department_id
			};
			$.ajax({
				url: "employees",
				method: "POST",
				data: data,
				dataType: 'json',
				beforeSend: function(xhr) {
					let validData = isValidData(data);
					if(!validData.flag) {
						printErrMsg(validData);
						xhr.abort();
					}
				},
				success: function(response) {
					console.log(response);
					if(response.status) {
						clearModal();
						getAllEmployees();
					}else {
						alert("추가중 에러가 발생했습니다.");
					}
				},
				error: function(e) {
					alert('에러 발생');
					console.log(e);
				}
			})
		});
		
		/* $("#findByName").on("keyup", function() {
			var value = $(this).val().toLowerCase();
			$("#employee_table tbody>tr>tdchild[1]").filter(function() {
		    	$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		}); */
		$("input[name='sort']").change(function(){
			searchEmp();
		});
		$("#findByName").on("keyup", function() {
			searchEmp();
		})
	});
	function searchEmp() {
		let sortData = ($("input[name='sort']:checked").val()).split(" ");
		let data = {
				name: $('#findByName').val().toLowerCase(),
				sort: sortData[0],
				method: sortData[1]
			}
		console.log(data);
		$.ajax({
			url: './searchEmployee',
			method: 'get',
			dataType: 'json',
			data: data,
			success: function(response) {
				outputEntireEmployees(response);
			},
			error: function(e) {
				console.log(e);
			}
		})
	}
	function getAllEmployees() {
		let url = "employees";
		$.ajax({
			url : url,
			type: "GET",
			dataType : "json",
			success: function(response) {
				empData = response;
				outputEntireEmployees(response);
				addSelect(response, "manager_id");
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
	
	function getAllJobs() {
		let url = "jobs"
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json",
			success: function(response) {
				jobData = response;
				addSelect(response, "job_id");
				makeSalInput('AD_PRES', "write");
			},
			error: function(e) {
				console.log(e);
			}
		})
	}
	
	function getAllDepartments() {
		let url = "departments";
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json",
			success: function(response) {
				deptData = response;
				addSelect(response, "department_id");
			},
			error: function(e) {
				console.log(e);
			}
		})
	}
	
	function outputEntireEmployees(json) {
		// 모든 직원 데이터 파싱 및 출력
		$("#outputDate").html(`\${json.outputDate}`);
		$("#outputCnt").html(`총 사원 : \${json.size}`);
		let output = `
			<table class="table table-striped" id="employee_table">
				<thead>
					<tr>
						<th>사원번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>입사일</th>
						<th>직급</th>
						<th>급여</th>
						<th>커미션 (%)</th>
						<th>매니저</th>
						<th>부서명</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>`;
		$.each(json.datas, function(i, item) {
			let managerId = item.manager_id;
			let managerName = "";
			$.each(empData.datas, function(i, mitem) {
				if(managerId == mitem.employee_id) {
					managerName = mitem.last_name + " " + mitem.first_name
				}
			})
			output+= `<tr>
						<td>\${item.employee_id}</td>
						<td>\${item.last_name} \${item.first_name}</td>
						<td>\${item.email}</td>
						<td>\${item.phone_number}</td>
						<td>\${item.hire_date}</td>
						<td>\${item.job_id}</td>
						<td>$ \${item.salary.toLocaleString('en-US')}</td>
						<td>\${item.commission_pct*100}</td>
						<td>\${managerName}</td>
						<td>\${item.department_name}</td>
						<td><img src="./assets/update.png" style="width:30px; cursor:pointer;" onclick='modifyModal(\${JSON.stringify(item)})'></td>
						<td><img src="./assets/delete.png" style="width:30px; cursor:pointer;" onclick='deleteEmployee(\${item.employee_id})'></td>
					 </tr>`;
		});
		output+=`
				</tbody>
			</table>
		`;
		$("#outputEmp").html(output);
	}
	
	function addSelect(datas, id) {
		if(id == 'job_id') {
			$.each(datas.datas, function(i, item) {
				$("#"+id).append(`<option>\${item.job_id}</option>`)
				$("#m_"+id).append(`<option>\${item.job_id}</option>`)
			});
		}else if(id == 'department_id') {
			$.each(datas.datas, function(i, item) {
				$("#"+id).append(`<option value=\${item.department_id}>\${item.department_name}</option>`)
				$("#m_"+id).append(`<option value=\${item.department_id}>\${item.department_name}</option>`)
			})
		}else if(id == 'manager_id') {
			$.each(datas.datas, function(i, item) {
				$("#"+id).append(`<option value=\${item.employee_id}>\${item.last_name} \${item.first_name}</option>`)
				$("#m_"+id).append(`<option value=\${item.employee_id}>\${item.last_name} \${item.first_name}</option>`)
			})
		}
	}
	
	function makeSalInput(job_id, mode) {
		let minSal = 0;
		let maxSal = 0;
		let avgSal = 0;
		$.each(jobData.datas, function(i, item) {
			if(job_id == item.job_id) {
				minSal = item.min_salary;
				maxSal = item.max_salary;
				avgSal = (minSal+maxSal)/2
			}
		});
		if(mode == "write") {
			$("#salary").attr("max", maxSal);
			$("#salary").attr("min", minSal);
			$("#salary").attr("value", avgSal);
			$("#salary_display").html(avgSal);
		}else if(mode == "modify"){
			$("#m_salary").attr("max", maxSal);
			$("#m_salary").attr("min", minSal);
			$("#m_salary").attr("value", avgSal);
			$("#m_salary_display").html(avgSal);
		}
	}
	
	function isValidData(data) {
		let returnData = {
				flag: true,
				message: ""
		}
		if(!isNull(data.last_name)) {
			returnData.flag = false;
			returnData.id = 'last_name';
			returnData.message = "성을 입력하세요.";
		}else if(!isNull(data.email) ) {
			returnData.flag = false;
			returnData.id = 'email';
			returnData.message = "이메일을 입력하세요.";
		}else if(!checkEmailDuplicate(data.email)) {
			returnData.flag = false;
			returnData.id = 'email';
			returnData.message = "중복된 이메일 입니다.";
		}else if(!isNull(data.hire_date)) {
			returnData.flag = false;
			returnData.id = 'hire_date';
			returnData.message = "입사일 입력하세요.";
		}else if(!isNull(data.job_id) | !isValidSelect('job_id', data.job_id)) {
			returnData.flag = false;
			returnData.id = 'job_id';
			returnData.message = "알맞은 직급을 선택하세요.";
		}else if(!isNull(data.manager_id) | !isValidSelect('employee_id', data.manager_id)) {
			returnData.flag = false;
			returnData.id = 'manager_id';
			returnData.message = "알맞은 매니저를 선택하세요.";
		}else if(!isNull(data.department_id) | !isValidSelect('department_id', data.department_id)) {
			returnData.flag = false;
			returnData.id = 'department_id';
			returnData.message = "알맞은 부서를 선택하세요.";
		}
		return returnData;
	}
	
	function isNull(data) {
		if(data === null | data === undefined | data === "") {
			return false;
		}else {
			return true;
		}
	}

	
	function isValidSelect(key, value) {
		let data = null;
		if(key == 'job_id') {
			data = jobData;
		}else if(key == 'department_id') {
			data = deptData;
		}else if(key == 'employee_id') {
			data = empData;
		}
		if(data) {
			for(let id of data.datas) {
				if(value == id[key]) {
					return true;
				}
			}
		}
		return false;
	}

	function checkEmailDuplicate(email) {
		let isEmailNotDup = true;
		$.each(empData.datas, function(i, e) {
			if((e.email).toUpperCase() == email.toUpperCase()) {
				isEmailNotDup = false;
			}
		})
		return isEmailNotDup;
	}
	
	function printErrMsg(data) {
		let errMsg = `<div class='errMsg' style="width:100%; color:red;">\${data.message}</div>`;
		$(errMsg).insertAfter($(`#\${data.id}`)).parent();
		$(`#\${data.id}`).focus();
		$(".errMsg").slideUp(5000);
	}
	
	function clearModal() {
		$("#myModal").modal('toggle');
		$("#first_name").val('');
		$("#last_name").val('');
		$("#email").val('');
		$("#phone_number").val('');
		$("#hire_date").val('');
		$("#job_id").val('');
		$("#salary").val('');
		$("#salary_display").text('0');
		$("#commission_pct").val(0);
		$("#manager_id").val('');
		$("#department_id").val('');
	}
	
	function modifyModal(emp) {
		$("#m_employee_id").val(emp.employee_id);
		$("#m_first_name").val(emp.first_name);
		$("#m_last_name").val(emp.last_name);
		$("#m_email").val(emp.email);
		$("#m_phone_number").val(emp.phone_number);
		$("#m_hire_date").val(emp.hire_date);
		$("#m_job_id").val(emp.job_id);
		makeSalInput(emp.job_id, "modify");
		$("#m_salary").val(emp.salary);
		$("#m_salary_display").html(emp.salary);
		$("#m_commission_pct").val(emp.commission_pct*100);
		$("#m_manager_id").val(emp.manager_id);
		$("#m_department_id").val(emp.department_id);
		$("#modifyModal").modal('toggle');
	}
	
	function submitModify() {
		let employee_id = $("#m_employee_id").val();
		let last_name = $("#m_last_name").val();
		let first_name = $("#m_first_name").val();
		let email = $("#m_email").val();
		let phone_number = $("#m_phone_number").val();
		let hire_date = $("#m_hire_date").val();
		let job_id = $("#m_job_id").val();
		let salary = $("#m_salary").val();
		let commission_pct = $("#m_commission_pct").val();
		let manager_id = $("#m_manager_id").val();
		let department_id = $("#m_department_id").val();
		let data = {
			employee_id: employee_id,
			last_name: last_name,
			first_name: first_name,
			email: email,
			phone_number: phone_number,
			hire_date: hire_date,
			job_id: job_id,
			salary: salary,
			commission_pct: commission_pct=="" ? 0 : commission_pct,
			manager_id: manager_id,
			department_id: department_id
		};
		console.log(data);
		$.ajax({
			url: "./modify",
			method: "POST",
			data: data,
			beforeSend: function(xhr) {
				
			},
			success: function(response) {
				if(response.status) {
					alert("수정 완료");
					$("#modifyModal").toggle("modal");
					getAllEmployees();
				}else {
					console.log(response);
				}
			},
			error: function(e) {
				alert("수정중 에러 발생");
				console.log(e);
			}
		})
		return false;
	}
	
	function deleteEmployee(employee_id) {
		if(confirm(`사원번호 \${employee_id} 를 삭제하시겠습니까?`)) {
			$.ajax({
				url: "./deleteEmployee",
				method: "POST",
				data: {"employee_id" : employee_id},
				success: function(response) {
					if(response.status) {
						alert("삭제 성공");
						getAllEmployees();
					}
				},
				error: function(e) {
					alert("삭제중 에러 발생");
					console.log(e);
				}
			})
		}
	}
</script>
<style>
	#writeIcon {
		cursor: pointer;
		width: 50px;
		height: 50px;
		position: fixed;
		right:50px;
		top: 20px;
	}
	
	.essential {
		background-color: #ff00002e;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>Employees with AJAX</h1>
		<div>
			<div id="outputDate" class="genInfo">
			
			</div>
			<div id="outputCnt" class="genInfo">
			
			</div>
			<div>
				<input type="text" class="form-control" placeholder="사원 이름으로 검색하기" id="findByName">
				<div class="form-check">
				  <input type="radio" class="form-check-input sort" id="radio1" name="sort" value="employee_id ASC" checked>사번순 (오름차순)
				  <label class="form-check-label" for="radio1"></label>
				</div>
				<div class="form-check">
				  <input type="radio" class="form-check-input sort" id="radio2" name="sort" value="hire_date DESC">입사일순 (내림차순)
				  <label class="form-check-label" for="radio2"></label>
				</div>
				<div class="form-check">
				  <input type="radio" class="form-check-input sort" name="sort" value="salary DESC">급여순 (내림차순)
				  <label class="form-check-label"></label>
				</div>
			</div>
		</div>
		
		<div id="outputEmp" class="empInfo">
		
		</div>
		<img src="./assets/insert.png" id="writeIcon" alt="직원 추가" data-bs-toggle="modal" data-bs-target="#myModal">
	</div>
	
	
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title" id="modal-title">사원 입력</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		    <input type="hidden" class="form-control" name="employee_id" id="employee_id">
		  <div class="input-group p-3">
		    <span class="input-group-text essential">성</span>
		    <input type="text" class="form-control" placeholder="성" name="last_name" id="last_name">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">이름</span>
		    <input type="text" class="form-control" placeholder="이름" name="first_name" id="first_name">
	   	  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">이메일</span>
		    <input type="text" class="form-control" placeholder="이메일" name="email" id="email">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">전화번호</span>
		    <input type="text" class="form-control" placeholder="전화번호" name="phone_number" id="phone_number">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">입사일</span>
		    <input type="date" class="form-control" name="hire_date" id="hire_date">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">직급</span>
			<select class="form-select" id="job_id">
			</select>
		  </div>
		  <div class="input-group p-3">
		    <div class="w-100"><span id="salary_display" class="" style="text-align: center;"></span></div>
		    <span class="input-group-text">급여</span>
		    <input type="range" class="form-control" placeholder="급여" name="salary" id="salary">
		  </div>
		  <div class="input-group p-3">
		    <input type="number" class="form-control" placeholder="커미션" name="commission_pct" id="commission_pct">
		    <span class="input-group-text">%</span>
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">매니저</span>
			<select class="form-select" id="manager_id">
				<option value="">
					매니저를 선택하세요
				</option>
			</select>
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">부서</span>
			<select class="form-select" id="department_id">
				<option value="">
					부서를 선택하세요
				</option>
			</select>
		  </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="writeBtn btn btn-success">저장</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>

<div class="modal fade" id="modifyModal">
  <div class="modal-dialog">
    <div class="modal-content">
		<form action="#" onsubmit="return false;" id="modifyForm">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title" id="modal-title">사원 정보 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		    <input type="hidden" class="form-control" name="employee_id" id="m_employee_id">
		  <div class="input-group p-3">
		    <span class="input-group-text essential">성</span>
		    <input type="text" class="form-control" placeholder="성" name="last_name" id="m_last_name">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">이름</span>
		    <input type="text" class="form-control" placeholder="이름" name="first_name" id="m_first_name">
	   	  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">이메일</span>
		    <input type="text" class="form-control" placeholder="이메일" name="email" id="m_email">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">전화번호</span>
		    <input type="text" class="form-control" placeholder="전화번호" name="phone_number" id="m_phone_number">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">입사일</span>
		    <input type="date" class="form-control" name="hire_date" id="m_hire_date">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">직급</span>
			<select class="form-select" id="m_job_id">
			</select>
		  </div>
		  <div class="input-group p-3">
		    <div class="w-100"><span id="m_salary_display" class="" style="text-align: center;"></span></div>
		    <span class="input-group-text">급여</span>
		    <input type="range" class="form-control" placeholder="급여" name="salary" id="m_salary">
		  </div>
		  <div class="input-group p-3">
		    <input type="number" class="form-control" placeholder="커미션" name="commission_pct" id="m_commission_pct">
		    <span class="input-group-text">%</span>
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">매니저</span>
			<select class="form-select" name="manager_id" id="m_manager_id">
				<option value="">
					매니저를 선택하세요
				</option>
			</select>
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text essential">부서</span>
			<select class="form-select" name="department_id" id="m_department_id">
				<option value="">
					부서를 선택하세요
				</option>
			</select>
		  </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="submit" class="modifyBtn btn btn-success" onclick="submitModify()">수정</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      </div>
	</form>
    </div>
  </div>
</div>
</body>
</html>