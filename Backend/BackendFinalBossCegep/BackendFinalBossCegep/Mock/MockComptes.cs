using BackendFinalBossCegep.Model;

namespace BackendFinalBossCegep.Mock
{
    public class MockComptes
    {
        public List<Compte> listComptes;

        public MockComptes() 
        {
            listComptes = new List<Compte>();
            listComptes.Add(new Compte("elie@allo.allo", "password"));
            listComptes.Add(new Compte("keva@allo.allo", "chat"));
        }
    }
}
