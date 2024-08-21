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
			makeSalInput($(this).val());
		})
		
		$("#salary").change(function() {
			$("#salary_display").html($(this).val());
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
				commission_pct: commission_pct,
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
						alert(validData.message);
						xhr.abort();
					}
				},
				success: function(response) {
					console.log(response);
				},
				error: function(e) {
					console.log(e);
				}
			})
		})
	});
	
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
				makeSalInput('AD_PRES');
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
			<table class="table table-striped">
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
						<td><img src="./assets/update.png" style="width:30px; cursor:pointer;"></td>
						<td><img src="./assets/delete.png" style="width:30px; cursor:pointer;"></td>
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
			});
		}else if(id == 'department_id') {
			$.each(datas.datas, function(i, item) {
				$("#"+id).append(`<option value=\${item.department_id}>\${item.department_name}</option>`)
			})
		}else if(id == 'manager_id') {
			$.each(datas.datas, function(i, item) {
				$("#"+id).append(`<option value=\${item.employee_id}>\${item.last_name} \${item.first_name}</option>`)
			})
		}
	}
	
	function makeSalInput(job_id) {
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

		$("#salary").attr("min", minSal);
		$("#salary").attr("max", maxSal);
		$("#salary").attr("value", avgSal);
		$("#salary_display").html(avgSal);
	}
	
	function isValidData(data) {
		let returnData = {
				flag: true,
				message: ""
		}
		if(!isNull(data.last_name)) {
			returnData.flag = false;
			returnData.message = "성을 입력하세요.";
		}else if(!isNull(data.email)) {
			returnData.flag = false;
			returnData.message = "이메일을 입력하세요.";
		}else if(!isNull(data.hire_date)) {
			returnData.flag = false;
			returnData.message = "입사일 입력하세요.";
		}else if(!isNull(data.job_id) | !isValidSelect('job_id', data.job_id)) {
			returnData.flag = false;
			returnData.message = "알맞은 직급을 선택하세요.";
		}else if(!isNull(data.department_id) | !isValidSelect('department_id', data.department_id)) {
			returnData.flag = false;
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
        <h4 class="modal-title">사원 입력</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		  <div class="input-group p-3">
		    <span class="input-group-text">성</span>
		    <input type="text" class="form-control" placeholder="성" name="last_name" id="last_name">
		    <span class="input-group-text">이름</span>
		    <input type="text" class="form-control" placeholder="이름" name="first_name" id="first_name">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">이메일</span>
		    <input type="text" class="form-control" placeholder="이메일" name="email" id="email">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">전화번호</span>
		    <input type="text" class="form-control" placeholder="전화번호" name="phone_number" id="phone_number">
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">입사일</span>
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
		    <span class="input-group-text">매니저</span>
			<select class="form-select" id="manager_id">
			</select>
		  </div>
		  <div class="input-group p-3">
		    <span class="input-group-text">부서</span>
			<select class="form-select" id="department_id">
			</select>
		  </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="writeBtn btn btn-success">저장</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>