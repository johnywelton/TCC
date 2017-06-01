
module.exports = function(app){

    let disciplinaModel = app.models.disciplinas;
    let cursoModel = app.models.cursos;

    var DisciplinaController = {
        index: function(req,res){
            disciplinaModel.selectDisciplina(req.body,function(results){
                res.render('disciplinas/index',{disciplinas: results});
            });
        },
        create: function(req,res){
            cursoModel.selectCursos(req.body,function(results){
                res.render('disciplinas/create',{cursos: results});
            });
        },
        saveDisciplina : function(req,res){
            disciplinaModel.saveDisciplina(req.body,function(results){
                res.status(200).json(results);
            });
                res.redirect('/disciplinas/');
            
        } 
    }

    return DisciplinaController;
}