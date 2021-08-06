<div class="row">
	<div class="col-md-12">
		<div class="card">
		<c:if test="${clsList == null}">
			<div class="card-header card-header-primary">
				<h4 class="card-title">Add New Subject</h4>
				<p class="card-category"></p>
			</div>
		</c:if>
		<c:if test="${clsList != null}">
			<div class="card-header card-header-primary">
				<h4 class="card-title">Edit Class</h4>
				<p class="card-category"></p>
			</div>
		</c:if>
			<div class="card-body">
			<c:if test="${subject == null }" >
				<form action="subject?pageid=su&action=insert" method="post">
			</c:if>
			<c:if test="${subject != null }" >
				<form action="subject?pageid=su&action=update" method="post">
			</c:if>
					<div class="row">
						<c:if test="${subject == null}" >
								<div class="col-md-6">
									<div class="form-group">
										<label class="bmd-label-floating">Enter Subject Title</label> 
										<input type="text" name="title" class="form-control">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="bmd-label-floating">Enter Subject Type</label> 
										<input type="text" name="type" class="form-control">
									</div>
								</div>
						</c:if>
						<c:if test="${subject != null}" >
								<div class="col-md-6">
									<div class="form-group">
										<label class="bmd-label-floating">Enter Subject Title</label> 
										<input type="text" name="title" value="<c:out value='${subject.title}' /> class="form-control">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="bmd-label-floating">Enter Subject Type</label> 
										<input type="text" name="type" value="<c:out value='${subject.type}' /> class="form-control">
									</div>
									<input type="hidden" name="id" value="<c:out value='${subject.id}' />" />
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

