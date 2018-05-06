<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="tab-pane profile active" id="profile-tab">
							<div class="row">
								<div class="col-md-3">
									<div class="user-info-left">
										
										<h2>${sessionScope.currentuser.name}<i class="fa fa-circle green-font online-icon"></i><sup class="sr-only">online</sup></h2>
										<div class="contact">
											
											<a href="${pageContext.request.contextPath}/updateprofile" class="btn btn-block btn-custom-secondary"><i class="fa fa-book"></i> Update Profile</a>
											
										</div>
									</div>
								</div>
								<div class="col-md-9">
									<div class="user-info-right">
										<div class="basic-info">
											<h3><i class="fa fa-square"></i> Basic Information</h3>
											<p class="data-row">
												<span class="data-name">Username</span>
												<span class="data-value">${sessionScope.currentuser.name}</span>
											</p>
					
											<p class="data-row">
												<span class="data-name">Last Name</span>
												<span class="data-value">${sessionScope.currentuser.lastname}</span>
											</p>
											<p class="data-row">
												<span class="data-name">First Name</span>
												<span class="data-value">${sessionScope.currentuser.firstname}</span>
											</p>
											<p class="data-row">
												<span class="data-name">Department</span>
												<span class="data-value">${sessionScope.currentuser.department}</span>
											</p>
											<p class="data-row">
												<span class="data-name">Role</span>
												<span class="data-value">${sessionScope.currentuser.type}</span>
											</p>
											
											
										</div>
										<div class="contact_info">
											<h3><i class="fa fa-square"></i> Contact Information</h3>
											<p class="data-row">
												<span class="data-name">Phone No.</span>
												<span class="data-value">${sessionScope.currentuser.phonenumber}</span>
											</p>
											<p class="data-row">
												<span class="data-name">Country Code</span>
												<span class="data-value">${sessionScope.currentuser.countrycode}</span>
											</p>
										</div>
										
									</div>
								</div>
				
						</div>
						</div>
						

