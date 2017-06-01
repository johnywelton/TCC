module.exports = function(app){

    let alunoModel = app.models.alunos;
    let cursoModel = app.models.cursos;

    var AlunoController = {
        index: function(req,res){
            alunoModel.selectAluno(req.body,function(results){
                res.render('alunos/index',{alunos: results});
            });
        },
        create: function(req,res){
            cursoModel.selectCursos(req.body,function(results){
                res.render('alunos/create',{cursos: results});
            });
        },
        saveAluno : function(req,res){
            alunoModel.saveAluno(req.body,function(results){
                res.status(200).json(results);
            });
                res.redirect('/alunos/');
            
        } 
    }

    return AlunoController;
}