<div class="row">
	<div class="col-md-12">
		<div class="card">
			<c:if test="${student == null}">
				<div class="card-header card-header-primary">
					<h4 class="card-title">Add New Student</h4>
					<p class="card-category"></p>
				</div>
			</c:if>
			<c:if test="${student != null}">
				<div class="card-header card-header-primary">
					<h4 class="card-title">Edit Student</h4>
					<p class="card-category"></p>
				</div>
			</c:if>
			<div class="card-body">
				<c:if test="${student == null }">
					<form action="student?pageid=st&action=insert" method="post">
				</c:if>
				<c:if test="${student != null }">
					<form action="student?pageid=st&action=update" method="post">
				</c:if>
				<div class="row">
					<c:if test="${student == null}">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="bmd-label-floating">First Name</label> 
									<input type="text" name="firstname" class="form-control">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="bmd-label-floating">Last Name</label> <input
										type="text" name="lastname" class="form-control">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="bmd-label-floating">Gender</label> <select
										name="gender" class="form-control">
										<option value="">---Select Gender</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="bmd-label-floating">Assign a Class</label> 
									<select name="class_id" class="form-control">
										<option value="">---Assign a Class---</option>
										<c:if test="${cL != null }">
											<c:forEach var="cls" items="${cL}">
												<option value="<c:out value='${cls.id}' />">
													<c:out value='${cls.className }' />
												</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="bmd-label-floating">Email</label> <input
										type="email" name="email" class="form-control">

								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="bmd-label-floating">Phone</label> <input
										type="text" name="phone" class="form-control">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="bmd-label-floating">Address</label>
									<input type="text" name="address" class="form-control">
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${student != null}">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">First Name</label> <input
									type="text" name="firstname" value="<c:out value='${student.firstname }' />" class="form-control">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Last Name</label> <input
									type="text" name="lastname" value="<c:out value='${student.lastname }' />" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Gender</label> <select
									name="gender" class="form-control">
									<option value="">---Select Gender</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Assign a Class</label> <select
									name="class_id" class="form-control">
									<option value="">---Assign a Class---</option>
									<c:if test="${cL != null }">
										<c:forEach var="cls" items="${cL}">
											<option value="<c:out value='${cls.id}' />">
												<c:out value='${cls.className }' />
											</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Email</label> <input
									type="email" name="email" value="<c:out value='${student.email }' />" class="form-control">

							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Phone</label> 
								<input type="text" name="phone" value="<c:out value='${student.phone}' />" class="form-control">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="bmd-label-floating">Address</label>
									 <input type="text" name="address" value="<c:out value='${student.address }' />" class="form-control">
							</div>
						</div>
					</div>
					
				</c:if>

				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
				<div class="clearfix"></div>
				</form>
			</div>
		</div>
	</div>
</div>

