module.exports = function(app){

    let cursoModel = app.models.cursos;

    var CursoController = {
        index: function(req,res){
            cursoModel.selectCursos(req.body,function(results){
                res.render('cursos/index',{cursos: results});
            });
        },

        create: function(req,res){
            res.render('cursos/create');
        },

        saveCurso : function(req,res){
            cursoModel.saveCurso(req.body,function(results){
                res.status(200).json(results);
            });
                res.redirect('/cursos/');
            
        } 
    }

    return CursoController;
}