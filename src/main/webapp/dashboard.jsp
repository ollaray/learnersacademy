    <div class="row">
    <% String id = request.getParameter("id"); %>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-warning card-header-icon">
                  <div class="card-icon">
                    
                    <i class="fa fa-id-card"></i>
                  </div>
                  <p class="card-category">Total Students</p>
                  <h3 class="card-title">
                  	<c:out value="${studentTotal}" />
                    <!-- <small>GB</small> -->
                  </h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons text-danger"></i>
                    <a href="student?pageid=st&action=">Student Master List</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-success card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">store</i>
                  </div>
                  <p class="card-category">Total Teachers</p>
                  <h3 class="card-title">
                  	<c:out value="${teacherTotal}" />
                  </h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">date_range</i>
                     <a href="teacher?pageid=te&action=hyudhett">Teacher Master List</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-danger card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">info_outline</i>
                  </div>
                  <p class="card-category">Subjects</p>
                  <h3 class="card-title"><c:out value="${subjectTotal }" /></h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">local_offer</i> 
                     <a href="subject?pageid=su&action=">Subject List</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-info card-header-icon">
                  <div class="card-icon">
                     <i class="fa fa-folder-open"></i>
                  </div>
                  <p class="card-category">Total Classes</p>
                  <h3 class="card-title"><c:out value="${classTotal}" /></h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">update</i> 
                     <a href="class?pageid=cl&action=">Class List</a>
                  </div>
                </div>
              </div>
            </div>
          </div>