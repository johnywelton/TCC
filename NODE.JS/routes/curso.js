module.exports = function(app){

    var curso = app.controllers.cursos;

    app.route('/cursos').get(curso.index);
    app.route('/cursos/create')
        .get(curso.create)
        .post(curso.saveCurso);
}

