const btnCriarTarefa = document.getElementById("btn-criar-tarefa")
var tarefas = localStorage.getItem("tarefas");

if(!tarefas){
    localStorage.setItem("tarefas", JSON.stringify([]))
    localStorage.setItem("acumulador_tarefa_id", 1)
} else {
    var tableTarefa = document.getElementsByClassName("table")[0].lastElementChild

    JSON.parse(tarefas).forEach(function(tarefa){
        tableTarefa.innerHTML += rowTableTarefa(tarefa)
    })
}

btnCriarTarefa.onclick = function() {
    window.location.href = "/front-end/views/create-task.html"
}

function deleteTarefa(elemento){
    elemento.parentElement.parentElement.remove()
    deleteTarefaStorage(elemento.parentElement.parentElement.id)
}

function deleteTarefaStorage(id){
    var tarefas = JSON.parse(localStorage.getItem("tarefas"))
    var pos = 0

    tarefas.forEach(function(tarefa){
        if(tarefa.id == id){
            tarefas.splice(pos, 1)
            localStorage.setItem("tarefas", JSON.stringify(tarefas))
            return true
        }

        pos++
    })

    return false
}

function rowTableTarefa(tarefa){
    return `<tr id="${tarefa.id}">
              <td>${tarefa.nome}</td>
              <td>${tarefa.descricao}</td>
              <td>${tarefa.prazo}</td>
              <td>${tarefa.prioridade}</td>
              <td>${tarefa.status}</td>
              <td>
                <input type="button" value="apagar" onclick="deleteTarefa(this)">
                <input type="button" value="editar" onclick="updateTarefa(this)">
              </td>
            </tr>`
}

function updateTarefa(elemento){
    var tarefa = getTarefa(elemento.parentElement.parentElement.id)
    localStorage.setItem("tarefa-update", JSON.stringify(tarefa))
    window.location.href = "/front-end/views/editar-task.html"
}

function getTarefa(id){
    var tarefas = JSON.parse(localStorage.getItem("tarefas"))
    var tarefa_find;

    tarefas.forEach(function(tarefa) {
        if(tarefa.id == id) return tarefa_find = tarefa;
    })

    return tarefa_find;
}