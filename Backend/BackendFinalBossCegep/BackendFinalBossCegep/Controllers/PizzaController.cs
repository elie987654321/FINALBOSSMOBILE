using BackendFinalBossCegep.Database;
using BackendFinalBossCegep.Model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Infrastructure;

namespace BackendFinalBossCegep.Controllers
{
    [ApiController]
    [Route("[controller]/[action]")]
    public class PizzaController : ControllerBase
    {
        private readonly ApplicationDBContext _dbContext;

        public PizzaController(ApplicationDBContext dbContext)
        {
            this._dbContext = dbContext;
        }

        [HttpGet(Name = "GetAll")]
        public ActionResult<Pizza[]> GetAll()
        {
            Pizza[] tabPizza = _dbContext.dbSetPizza.ToArray();
            return Ok(tabPizza);
        }
    }
}
