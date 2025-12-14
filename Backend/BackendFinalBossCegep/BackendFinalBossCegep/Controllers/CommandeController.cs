using BackendFinalBossCegep.Database;
using BackendFinalBossCegep.Model;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.Mvc;

namespace BackendFinalBossCegep.Controllers
{
    [ApiController]
    [Route("[controller]/[action]")]
    public class CommandeController : ControllerBase
    {
        private readonly ApplicationDBContext _dbContext;

        public CommandeController(ApplicationDBContext applicationDBContext)
        {
            this._dbContext = applicationDBContext;
        }

        [HttpPost(Name ="AddCommande")]
        public ActionResult AddCommande(string nomClient, Decimal montant, DateTime date)
        {
            Commande commande = new Commande();
            commande.NomClient = nomClient;
            commande.Montant = montant;
            commande.Date = date;

            _dbContext.dbSetCommande.Add(commande);
            _dbContext.SaveChanges();
            return Ok();
        }
    }
}
