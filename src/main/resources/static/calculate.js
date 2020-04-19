function calculateAmount() {
  var amount = document.getElementById("requestedAmount").value;
  var url = "http://localhost:8080/loans/calculate?amount=" + amount;
  fetch(url)
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      document.getElementById("rate").textContent = data.rate;
      document.getElementById("monthlyPayment").textContent =
        data.monthlyPayment;
      document.getElementById("totalPayment").textContent = data.totalPayment;
    })
    .catch(function () {
      console.log("Error occured");
    });
}
