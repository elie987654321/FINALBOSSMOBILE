using System.ComponentModel.DataAnnotations.Schema;

namespace BackendFinalBossCegep.Model
{
    [Table("pizza")]
    public class Pizza
    {
        [Column("id")]
        public int Id { get; set; }
        [Column("sorte")]
        public string Sorte { get; set; }
        [Column("type")]
        public string Type { get; set; }
        [Column("image")]
        public int IdImage { get; set; }
    }
}
