module.exports = function(app){

    var professor = app.controllers.professores;

    app.route('/professores').get(professor.index);
    app.route('/professores/create')
        .get(professor.create)
        .post(professor.saveProfessor);
}

