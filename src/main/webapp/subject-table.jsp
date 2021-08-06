<div class="row">
	<div class="col-lg-12 col-md-12">
	<a href="subject?pageid=suf&&action=new" type="button" rel="tooltip" title="Create New Record" class="btn btn-success">
		Create
	</a>
		<div class="card">
			<div class="card-header card-header-tabs card-header-primary">
				<div class="nav-tabs-navigation">
					<div class="nav-tabs-wrapper">
						<span class="nav-tabs-title">SUBJECT MASTER LIST</span>
						<ul class="nav nav-tabs" data-tabs="tabs">
							
							
						</ul>
						
					</div>
				</div>
			</div>
			<% int i=1; %>
			<div class="card-body">
				<div class="tab-content">
					<div class="tab-pane active" id="profile">
						<table class="table">
							<tr>
				                <th>ID</th>
				                <th>Subject</th>
				                <th>Subject Type</th>
	          					<th>Action</th>
         					</tr>
							<tbody>
							<c:forEach var="sub" items="${subject}" > 
								<tr>
									<td>
										<%=i %>
									</td>
									<td>
										<c:out value= "${sub.title}" />
									</td>
									<td>
										<c:out value= "${sub.subjectType}" />
									</td>
									<td class="td-actions text-right">
										<a href="class?pageid=su&action=view&id=<c:out value='${sub.id}'/>" type="button" rel="tooltip" title="View Record"
											class="btn btn-primary">
											View
										</a>
										&nbsp;&nbsp;
										<a href="class?pageid=su&action=edit&id=<c:out value='${sub.id}'/>" type="button" rel="tooltip" title="Edit Record"
											class="btn btn-info">
											Edit
										</a>
										&nbsp;&nbsp;
										<a href="class?pageid=su&action=delete&id=<c:out value='${sub.id}'/>" type="button" rel="tooltip" title="Delete Record"
											class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this record?');">
											Delete
										</a>
									</td>
									
								</tr>
								<% i++; %>
							</c:forEach>
							</tbody>
						</table>
					</div>
			
				</div>
			</div>
		</div>
	</div>
</div>