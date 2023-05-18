// $(document).ready(function(){
// 	$("tr:odd").addClass("odd");
// });

$(function () {
    $('#search-button').click(function () {
        searchEmployees();
    });
});

function searchEmployees() {
    var query = $('#search-input').val();
    var fullName = document.getElementById('fullName').value;
    var year = document.getElementById('year').value;
    var month = document.getElementById('month').value;
    var email = document.getElementById('email').value;
    var project = document.getElementById('project').value;
    let count = 1;
    $.get('/stats/search?fullName=' + fullName + '&email=' + email + '&month=' + month + '&year=' + year + '&project=' + project, function (data) {
        const workList = document.getElementById('tbody'); workList.innerHTML = '';

        console.log(data);
        data.forEach(item => {
            const stt = item.id;
            const hovaten = item.fullName;
            const email = item.email;
            var newEle = document.createElement('tr');
            newEle.innerHTML = `<td class="stickyCol" rowspan="${(item.workData).length + 1}">${stt}</td>
                                        <td class="stickyCol truncate-text" rowspan="${(item.workData).length + 1}">${hovaten}</td>
                                    <td rowspan="${(item.workData).length + 1}">${email}</td>`;
            workList.appendChild(newEle);
            (item.workData).forEach(workdata => {
                count++;
                const project = workdata.projectName;
                const originalEstimated = Math.round(workdata.originalEstimated / 3600);
                const workLoggedInHours = Math.round(workdata.workLoggedInHours / 3600);
                const donePoint = Math.round(workdata.donePoint / 3600);
                const notDonePoint = Math.round(workdata.notDonePoint / 3600);
                const overDuePoint = Math.round(workdata.overDuePoint / 3600);
                const earlyDuePoint = Math.round(workdata.earlyDuePoint / 3600);
                const overPlanPoint = Math.round(workdata.overPlanPoint / 3600);
                const reopenPoint = Math.round(workdata.reopenPoint / 3600);
                const missing = Math.round(workdata.missing / 3600);
                const fatalBug = Math.round(workdata.fatalBug / 3600);
                const seriousBug = Math.round(workdata.seriousBug / 3600);
                const mediumBug = Math.round(workdata.mediumBug / 3600);
                const cosmeticBug = Math.round(workdata.cosmeticBug / 3600);
                const fatalBugReport = Math.round(workdata.fatalBugReport / 3600);
                const seriousBugReport = Math.round(workdata.seriousBugReport / 3600);
                const mediumBugReport = Math.round(workdata.mediumBugReport / 3600);
                const cosmeticBugReport = Math.round(workdata.cosmeticBugReport / 3600);

                var newEle1 = document.createElement('tr');
                newEle1.innerHTML = `<td> ${project}</td>
                                <td>${originalEstimated}</td>
                                    <td> ${missing}</td>
                                        <td> ${donePoint}</td>
                                            <td> ${notDonePoint}</td>
                                                <td> ${overDuePoint}</td>
                                                    <td> ${earlyDuePoint}</td>
                                                        <td> ${overPlanPoint}</td>
                                                            <td> ${reopenPoint}</td>
                                                            <td> ${workLoggedInHours}</td>
                                                                <td> ${fatalBug}</td>
                                                                    <td> ${seriousBug}</td>
                                                                        <td> ${mediumBug}</td>
                                                                            <td> ${cosmeticBug}</td>
                                                                                <td> ${fatalBugReport}</td>
                                                                                    <td> ${seriousBugReport}</td>
                                                                                        <td> ${mediumBugReport}</td>
                                                                                            <td> ${cosmeticBugReport}</td>
                                                                                            `; workList.appendChild(newEle1);
                if ((parseInt(count)) % 2 !== 0) {
                    newEle1.classList.add('odd');
                }
            });
        });
    });
}


//print all
var postApi = 'http://localhost:8088/stats/projectAPI';
fetch(postApi).then(function (response) {
    return response.json();
}).then(function (projects) {
    console.log(projects); projectList = projects;
    const project = document.getElementById('project');
    for (let i = 0; i < projects.length; i++) {

        project.innerHTML += `<option value="${projects[i]}">${projects[i]}</option>`;

    }
}).catch(function (err) {
    console.log('error fetching api!');
})

// const apiUrl = 'http://localhost:8088/stats/testAPI';
// fetch(apiUrl)
//     .then(response => response.json())
//     .then(data => {
//         console.log(data); // check if data is retrieved successfully

//         // process the data and display it on the HTML page
//         const apiDataElement = document.getElementById('api-data');
//         let html = '<ul>';

//         for (let key in data) {
//             html += `<li>${key}: ${data[key].workData.projectName}, ${data[key].workLoggedInHours}, ${data[key].donePoint}</li>`;
//         }

//         html += '</ul>';
//         apiDataElement.innerHTML = html;
//     })
//     .catch(error => {
//         console.error('Error:', error);
//     });






//       fetch('http://localhost:8088/stats/testAPI')
//   .then(response => response.json())
//   .then(data => {
//     const workList = document.getElementById('workList');
//     data.forEach(item => {
//         const hovaTen = item.fullName;
//       const project = item.workData[0].projectName;
//       const originalEstimated = item.workData[0].originalEstimated;
//       const workLoggedInHours = item.workData[0].workLoggedInHours;
//       const donePoint = item.workData[0].donePoint;
//       const notDonePoint = item.workData[0].notDonePoint;
//       const overDuePoint = item.workData[0].overDuePoint;
//       const earlyDuePoint = item.workData[0].earlyDuePoint;
//       const overPlanPoint = item.workData[0].overPlanPoint;
//       const reopenPoint = item.workData[0].reopenPoint;
//       const fatalBug = item.workData[0].fatalBug;
//       const seriousBug = item.workData[0].seriousBug;
//       const mediumBug = item.workData[0].mediumBug;
//       const cosmeticBug = item.workData[0].cosmeticBug;
//       const fatalBugReport = item.workData[0].fatalBugReport;
//       const seriousBugReport = item.workData[0].seriousBugReport;
//       const mediumBugReport = item.workData[0].mediumBugReport;
//       const cosmeticBugReport = item.workData[0].cosmeticBugReport;

//       const li = document.createElement('li');
//       li.innerHTML = `
//         <strong>FullName:</strong> ${hovaTen}</td>
//         <strong>Project:</strong> ${project}</td>
//         <strong>Original Estimated:</strong> ${originalEstimated}</td>
//         <strong>Work Logged In Hours:</strong> ${workLoggedInHours}</td>
//         <strong>Done Point:</strong> ${donePoint}</td>
//         <strong>Not Done Point:</strong> ${notDonePoint}</td>
//         <strong>Over Due Point:</strong> ${overDuePoint}</td>
//         <strong>Early Due Point:</strong> ${earlyDuePoint}</td>
//         <strong>Over Plan Point:</strong> ${overPlanPoint}</td>
//         <strong>Reopen Point:</strong> ${reopenPoint}</td>
//         <strong>Fatal Bug:</strong> ${fatalBug}</td>
//         <strong>Serious Bug:</strong> ${seriousBug}</td>
//         <strong>Medium Bug:</strong> ${mediumBug}</td>
//         <strong>Cosmetic Bug:</strong> ${cosmeticBug}</td>
//         <strong>Fatal Bug Report:</strong> ${fatalBugReport}</td>
//         <strong>Serious Bug Report:</strong> ${seriousBugReport}</td>
//         <strong>Medium Bug Report:</strong> ${mediumBugReport}</td>
//         <strong>Cosmetic Bug Report:</strong> ${cosmeticBugReport}
//       `;
//       workList.appendChild(li);
//     });
//   });

fetch('http://localhost:8088/stats/testAPI')
    .then(response => response.json())
    .then(data => {
        const workList = document.getElementById('tbody');
        let count = 1;
        data.forEach(item => {
            const stt = item.id;
            const hovaten = item.fullName;
            const email = item.email;
            var newEle = document.createElement('tr');
            newEle.innerHTML = `<td class="stickyCol" rowspan="${(item.workData).length + 1}">${stt}</td>
                                        <td class="stickyCol truncate-text" rowspan="${(item.workData).length + 1}">${hovaten}</td>
                                    <td rowspan="${(item.workData).length + 1}">${email}</td>`;
            workList.appendChild(newEle);
            (item.workData).forEach(workdata => {
                count++;
                const project = workdata.projectName;
                const originalEstimated = Math.round(workdata.originalEstimated / 3600);
                const workLoggedInHours = Math.round(workdata.workLoggedInHours / 3600);
                const donePoint = Math.round(workdata.donePoint / 3600);
                const notDonePoint = Math.round(workdata.notDonePoint / 3600);
                const overDuePoint = Math.round(workdata.overDuePoint / 3600);
                const earlyDuePoint = Math.round(workdata.earlyDuePoint / 3600);
                const overPlanPoint = Math.round(workdata.overPlanPoint / 3600);
                const reopenPoint = Math.round(workdata.reopenPoint / 3600);
                const missing = Math.round(workdata.missing / 3600);
                const fatalBug = Math.round(workdata.fatalBug / 3600);
                const seriousBug = Math.round(workdata.seriousBug / 3600);
                const mediumBug = Math.round(workdata.mediumBug / 3600);
                const cosmeticBug = Math.round(workdata.cosmeticBug / 3600);
                const fatalBugReport = Math.round(workdata.fatalBugReport / 3600);
                const seriousBugReport = Math.round(workdata.seriousBugReport / 3600);
                const mediumBugReport = Math.round(workdata.mediumBugReport / 3600);
                const cosmeticBugReport = Math.round(workdata.cosmeticBugReport / 3600);

                var newEle1 = document.createElement('tr');
                newEle1.innerHTML = `<td> ${project}</td>
                                            <td>${originalEstimated}</td>
                                                <td> ${missing}</td>
                                                    <td> ${donePoint}</td>
                                                        <td> ${notDonePoint}</td>
                                                            <td> ${overDuePoint}</td>
                                                                <td> ${earlyDuePoint}</td>
                                                                    <td> ${overPlanPoint}</td>
                                                                        <td> ${reopenPoint}</td>
                                                                        <td> ${workLoggedInHours}</td>
                                                                            <td> ${fatalBug}</td>
                                                                                <td> ${seriousBug}</td>
                                                                                    <td> ${mediumBug}</td>
                                                                                        <td> ${cosmeticBug}</td>
                                                                                            <td> ${fatalBugReport}</td>
                                                                                                <td> ${seriousBugReport}</td>
                                                                                                    <td> ${mediumBugReport}</td>
                                                                                                        <td> ${cosmeticBugReport}</td>
                                                                                                        `; workList.appendChild(newEle1);
                if ((parseInt(count)) % 2 !== 0) {
                    newEle1.classList.add('odd');
                }
                // 

            });


        });
    });

