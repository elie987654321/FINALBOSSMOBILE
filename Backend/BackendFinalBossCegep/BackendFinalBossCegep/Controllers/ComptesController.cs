using BackendFinalBossCegep.Database;
using BackendFinalBossCegep.Model;
using Microsoft.AspNetCore.Mvc;

namespace BackendFinalBossCegep.Controllers
{
    [ApiController]
    [Route("[controller]/[action]")]
    public class CompteController : ControllerBase
    {
        private readonly ApplicationDBContext _dbContext;

        public CompteController(ApplicationDBContext dbContext)
        {
            this._dbContext = dbContext;
        }

        [HttpGet(Name="Connexion")]
        public ActionResult<Compte> GetCompteByEmailAndPassword(string email, string password)
        {
            Compte? compteTrouve = _dbContext.dbSetComptes.Where((compte) => compte.Email == email && compte.Password == password).FirstOrDefault();

            if (compteTrouve == null)
            {
                return NotFound();
            }
            return Ok(compteTrouve);
        }

        [HttpPost(Name="Inscription")]
        public ActionResult<Compte> CreateCompte(Compte compteJson)
        {
            Compte? compteTrouve = _dbContext.dbSetComptes.Where((compte) => compte.Email == compteJson.Email).FirstOrDefault();

            if (compteTrouve != null)
            {
                return Conflict("");
            }
            else
            {
                _dbContext.dbSetComptes.Add(compteJson);
                _dbContext.SaveChanges();

                return Ok(compteJson);
            }
        }
    }
}