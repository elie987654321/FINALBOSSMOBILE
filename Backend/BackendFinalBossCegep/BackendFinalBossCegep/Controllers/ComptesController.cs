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
        public Compte? GetCompteByEmailAndPassword(string email, string password)
        {
            Compte? compteTrouve = _dbContext.dbSetComptes.Where((compte) => compte.Email == email && compte.Password == password).FirstOrDefault();
            return compteTrouve;
        }

        [HttpGet(Name="Inscription")]
        public Compte? CreateCompte(string email, string password, string name, string address, string phone)
        {
            Compte? compteTrouve = _dbContext.dbSetComptes.Where((compte) => compte.Email == email).FirstOrDefault();

            if (compteTrouve != null)
            {
                return null;
            }
            else
            {
                Compte compte = new Compte(email, password, name, address, phone);
                _dbContext.dbSetComptes.Add(compte);
                _dbContext.SaveChanges();
                return compte;
            }
        }
    }
}