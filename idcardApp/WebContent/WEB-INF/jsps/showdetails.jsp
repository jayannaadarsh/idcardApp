<!DOCTYPE html>
<html lang="en">
<head>
<title>Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css" href="./resources/css/main.css">
</head>
<body>


	<div class="wrapper">
		<div class="container">

			<div class="details-wrap">
				<div class="success-message">${crud} ${status}</div>
				<ul>
					<li>

						<div class="list-content">
							<h5>${student.name }</h5>
							<p>
								Father Name : <span>${student.fname }</span>
							</p>
							<p>
								Mother Name : <span>${student.mname }</span>
							</p>
							<p>
								Address : <span>${student.add } ${student.fileName }</span>
							</p>
							<img src="./resources/image/${student.fileName}" class="user-image" />
							
						</div>

					</li>



				</ul>

			</div>

			<a href="InputDetails" style="font-size: 20px;">Click to go Back</a>


		</div>

	</div>



</body>
</html>
