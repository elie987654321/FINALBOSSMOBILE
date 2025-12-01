using BackendFinalBossCegep.Mock;
using BackendFinalBossCegep.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace BackendFinalBossCegep.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CompteController : ControllerBase
    {
        [HttpGet]
        private IEnumerable<Compte> GetCompteByEmailAndPassword(string email, string password)
        {
            MockComptes mockComptes = new MockComptes();

            return mockComptes.listComptes.Where((compte) => compte.Email == email && compte.Password == password);
        }
    }
}
