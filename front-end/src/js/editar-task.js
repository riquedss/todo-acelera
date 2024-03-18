const btnCancelar = document.getElementById("btn-cancelar")
const btnSalvar = document.getElementById("btn-salvar")
const form = document.getElementsByClassName("form-todo")[0]
const tarefa = JSON.parse(localStorage.getItem("tarefa-update"))
var tarefas = JSON.parse(localStorage.getItem("tarefas"))

if(tarefa){
    form[0].value = tarefa.nome
    form[1].value = tarefa.descricao
    form[2].value = tarefa.prazo
    form[3].value = tarefa.prioridade
    form[4].value = tarefa.status
}

btnCancelar.onclick = function(){
    window.location.href = "/front-end/todo-index.html"
}

btnSalvar.onclick = function(){
    tarefa.nome = form[0].value,
    tarefa.descricao = form[1].value,
    tarefa.prazo = form[2].value,
    tarefa.prioridade = form[3].value,
    tarefa.status = form[4].value

    editarTarefaStorage(tarefa)

    clearForm(form)

    localStorage.setItem("tarefa-update", null)

    window.location.href = "/front-end/todo-index.html"
}

function editarTarefaStorage(tarefa){
    var pos = 0
    tarefas.forEach(function(elemento) {
        if(elemento.id == tarefa.id) {
            tarefas[pos] = tarefa
            return localStorage.setItem("tarefas", JSON.stringify(tarefas))
        }

        pos++
    })
}

function clearForm(form){
    for(let i = 0; i < 5; i++) form[i].value = ""
}