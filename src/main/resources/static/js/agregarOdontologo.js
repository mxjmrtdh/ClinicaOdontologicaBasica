const form = document.getElementById("agregarOdontologoForm");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const apellido = document.getElementById("apellido").value;
  const nombre = document.getElementById("nombre").value;
  const numeroMatricula = document.getElementById("matricula").value;


  // llamando al endpoint de agregar
  const datosFormulario = {
    nombre,
    apellido,
    numeroMatricula


  };

  fetch(`odontologo/guardar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datosFormulario),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("Odontologo agregado con éxito");
      form.reset(); // Resetear el formulario
    })
    .catch((error) => {
      console.error("Error agregando odontólogo:", error);
    });
});
