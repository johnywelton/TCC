module.exports = function(app){

    let professorModel = app.models.professores;

    var ProfessorController = {
        index: function(req,res){
            professorModel.selectProfessor(req.body,function(results){
                res.render('professores/index',{professores: results});
            });
        },
        create: function(req,res){
            res.render('professores/create');
        },
        saveProfessor : function(req,res){
            professorModel.saveProfessor(req.body,function(results){
                res.status(200).json(results);
            });
                res.redirect('/professores/');
            
        } 
    }

    return ProfessorController;
}