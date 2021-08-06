<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header card-header-primary">
				<h4 class="card-title">Edit Profile</h4>
				<p class="card-category">Complete your profile</p>
			</div>
			<div class="card-body">
				<form>
					<div class="row">
						<div class="col-md-5">
							<div class="form-group">
								<label class="bmd-label-floating">Company (disabled)</label> <input
									type="text" class="form-control" disabled>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label class="bmd-label-floating">Username</label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="bmd-label-floating">Email address</label> <input
									type="email" class="form-control">
							</div>
						</div>
					</div>
					<!-- -Start from here -->
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">First Name</label> <input
									type="text" name="firstname" class="form-control">
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
								<label class="bmd-label-floating">Gender</label> 
								<select name="gender" class="form-control">
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
									<c:if test="${cL != null }" >
										<c:forEach var="cls" items="cL" >
											<option value="<c:out value='${cls.id}' />"><c:out value='${cls.className }' /></option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
					</div>
						<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Email</label> 
								<input type="email" name="email" class="form-control">
									
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="bmd-label-floating">Phone</label> 
								<input type="text" name="phone" class="form-control">
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="bmd-label-floating">Address</label> <input
									type="text" class="form-control">
							</div>
						</div>
					</div>
					<!-- -end here -->
					
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class="bmd-label-floating">City</label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="bmd-label-floating">Country</label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="bmd-label-floating">Postal Code</label> <input
									type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>About Me</label>
								<div class="form-group">
									<label class="bmd-label-floating"> Lamborghini Mercy,
										Your chick she so thirsty, I'm in that two seat Lambo.</label>
									<textarea class="form-control" rows="5"></textarea>
								</div>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary pull-right">Update
						Profile</button>
					<div class="clearfix"></div>
				</form>
			</div>
		</div>
	</div>
</div>

