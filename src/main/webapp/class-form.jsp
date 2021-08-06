<div class="row">
	<div class="col-md-12">
		<div class="card">
		<c:if test="${clsList == null}">
			<div class="card-header card-header-primary">
				<h4 class="card-title">Add New Class</h4>
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
			<c:if test="${clsList == null }" >
				<form action="class?pageid=cl&action=insert" method="post">
			</c:if>
			<c:if test="${clsList != null }" >
				<form action="class?pageid=cl&action=update" method="post">
			</c:if>
					<div class="row">
						<div class="col-md-9">
							<div class="form-group">
								<c:if test="${clsList == null}" >
									<label class="bmd-label-floating">Enter Class Name</label> 
									<input type="text" name="name" class="form-control">
								</c:if>
								<c:if test="${clsList != null}" >
									<label class="bmd-label-floating">Enter Class Name</label> 
									<input type="text" name="name" value="<c:out value='${clsList.className}' />" class="form-control">
									<input type="hidden" name="id" value="<c:out value='${clsList.id}' />" />
								</c:if>
							</div>
						</div>
						
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<div class="clearfix"></div>
				</form>
			</div>
		</div>
	</div>
</div>

