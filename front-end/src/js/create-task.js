const btnCancelar = document.getElementById("btn-cancelar")
const btnSalvar = document.getElementById("btn-salvar")

btnCancelar.onclick = function(){
    window.location.href = "/front-end/todo-index.html"
}

btnSalvar.onclick = function(){
    var form = document.getElementsByClassName("form-todo")[0]
    var id = localStorage.getItem("acumulador_tarefa_id")
    var tarefas;

    var tarefa = {
        "id": id,
        "nome": form[0].value,
        "descricao": form[1].value,
        "prazo": form[2].value,
        "prioridade": form[3].value,
        "status": form[4].value
    }

    tarefas = JSON.parse(localStorage.getItem("tarefas"))
    tarefas.push(tarefa)
    localStorage.setItem("tarefas", JSON.stringify(tarefas))
    localStorage.setItem("acumulador_tarefa_id", parseInt(id) + 1)

    clearForm(form)

    window.location.href = "/front-end/todo-index.html"
}

function clearForm(form){
    for(let i = 0; i < 5; i++) form[i].value = ""
}