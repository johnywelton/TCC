var express         = require('express'),
    path            = require('path'),
    favicon         = require('static-favicon'),
    logger          = require('morgan'),
    cookieParser    = require('cookie-parser'),
    bodyParser      = require('body-parser'),
    session         = require('express-session'),
    mysql           = require('mysql'),
    load            = require('express-load'),
    connection      = require('express-myconnection');

var app = express();

//middleware
var erros = require('./middleware/erros');

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(favicon());
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cookieParser());
app.use(session({ secret: 'sua-chave-secreta' }));
app.use(express.static(path.join(__dirname, 'public')));

load('models').then('controllers').then('routes').into(app);

//middleware
app.use(erros.notfound);
app.use(erros.serverError);

var server = app.listen(3000, function(){
    var host = server.address().address;
    var port = server.address().port;
    console.log('Conexão efetuada com sucesso na porta http://%s:%s', host, port);
});

