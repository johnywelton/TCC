module.exports = function(app){

    var disciplina = app.controllers.disciplinas;

    app.route('/disciplinas').get(disciplina.index);
    app.route('/disciplinas/create')
        .get(disciplina.create)
        .post(disciplina.saveDisciplina);
}

