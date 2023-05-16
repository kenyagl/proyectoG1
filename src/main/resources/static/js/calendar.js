
function mostrarMesAnterior() {
    var currentMonthElement = document.getElementById("currentMonth");
    var currentMonthYear = currentMonthElement.textContent.split(" ");
    var currentMonth = parseInt(currentMonthYear[0]);
    var currentYear = parseInt(currentMonthYear[1]);
    
    if (currentMonth === 1) {
        currentMonth = 12;
        currentYear--;
    } else {
        currentMonth--;
    }
    
    window.location.href = "/calendario?month=" + currentMonth + "&year=" + currentYear;
}

function mostrarMesSiguiente() {
    var currentMonthElement = document.getElementById("currentMonth");
    var currentMonthYear = currentMonthElement.textContent.split(" ");
    var currentMonth = parseInt(currentMonthYear[0]);
    var currentYear = parseInt(currentMonthYear[1]);
    
    if (currentMonth === 12) {
        currentMonth = 1;
        currentYear++;
    } else {
        currentMonth++;
    }
    
    window.location.href = "/calendario?month=" + currentMonth + "&year=" + currentYear;
}